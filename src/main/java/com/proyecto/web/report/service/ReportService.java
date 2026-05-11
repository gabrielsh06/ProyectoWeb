package com.proyecto.web.report.service;

import com.proyecto.web.domain.Sale;
import com.proyecto.web.report.dto.ReportDTO;
import com.proyecto.web.report.dto.SaleItemDTO;
import com.proyecto.web.report.dto.SaleRowDTO;
import com.proyecto.web.report.dto.TopProductDTO;
import com.proyecto.web.sale.repository.SaleDetailRepository;
import com.proyecto.web.sale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    
        public List<SaleRowDTO> getSalesHistory() {
        List<Sale> sales = saleRepository.findAll();
        List<SaleRowDTO> history = new ArrayList<>();

        for (Sale sale : sales) {
            SaleRowDTO dto = new SaleRowDTO();
            dto.setSaleId(sale.getId());
            dto.setDate(sale.getDate() != null ? sale.getDate().toString().substring(0, 10) : "Sin fecha");
            
            if (sale.getCustomer() != null) {
                dto.setCustomerName(sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName());
            } else {
                dto.setCustomerName("Público en General");
            }
            
            dto.setTotal(sale.getTotal());

            // --- NUEVO: Extraer los productos y cantidades de esta venta ---
            List<SaleItemDTO> itemsList = new ArrayList<>();
            if (sale.getDetails() != null) {
                for (var detail : sale.getDetails()) {
                    SaleItemDTO item = new SaleItemDTO();
                    item.setProductName(detail.getProduct().getName());
                    item.setQuantity(detail.getQuantity());
                    itemsList.add(item);
                }
            }
            dto.setItems(itemsList);
            // ----------------------------------------------------------------

            history.add(dto);
        }
        
        return history;
    }
    public ReportDTO generateMonthlyReport() {
        ReportDTO report = new ReportDTO();

        //Obtener totales
        BigDecimal totalSales = saleRepository.calculateTotalSales();
        if (totalSales == null) totalSales = BigDecimal.ZERO;

        Long totalTx = saleRepository.countTransactions();
        if (totalTx == null) totalTx = 0L;

        //Calcular ticket promedio
        BigDecimal avgTicket = BigDecimal.ZERO;
        if (totalTx > 0) {
            avgTicket = totalSales.divide(BigDecimal.valueOf(totalTx), 2, RoundingMode.HALF_UP);
        }

        report.setTotalSales(totalSales);
        report.setTotalTransactions(totalTx);
        report.setAverageTicket(avgTicket);

        // Transformar la lista del Top 5
        List<Object[]> rawTop = saleDetailRepository.getTopSellingProducts();
        List<TopProductDTO> top = new ArrayList<>();
        
        int limit = Math.min(rawTop.size(), 5);
        for (int i = 0; i < limit; i++) {
            Object[] row = rawTop.get(i);
            TopProductDTO dto = new TopProductDTO();
            dto.setName((String) row[0]);
            dto.setCategory((String) row[1]);
            dto.setQuantity((Long) row[2]); 
            dto.setSubtotal((BigDecimal) row[3]);
            top.add(dto);
        }

        report.setTopProducts(top);

        return report;
    }
}