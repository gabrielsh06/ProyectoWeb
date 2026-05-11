package com.proyecto.web.report.controller;

import com.proyecto.web.report.dto.ReportDTO;
import com.proyecto.web.report.dto.SaleRowDTO;
import com.proyecto.web.report.service.ReportService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reports") 
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/summary")
    public ResponseEntity<ReportDTO> getReportSummary() {
        ReportDTO report = reportService.generateMonthlyReport();
        return ResponseEntity.ok(report);
    }
    // Añade esta ruta a tu ReportController
    @GetMapping("/history")
    public ResponseEntity<List<SaleRowDTO>> getSalesHistory() {
        return ResponseEntity.ok(reportService.getSalesHistory());
    }
}