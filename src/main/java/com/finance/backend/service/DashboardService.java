package com.finance.backend.service;

import com.finance.backend.dto.response.DashboardResponse;

public interface DashboardService {
    DashboardResponse getDashboard(Long id);
}
