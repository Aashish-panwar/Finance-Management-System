package com.finance.backend.controller;

import com.finance.backend.dto.response.DashboardResponse;
import com.finance.backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("{id}")
    public ResponseEntity<DashboardResponse> getDashboard(@PathVariable Long id){
        return ResponseEntity.ok(dashboardService.getDashboard(id));
    }
}