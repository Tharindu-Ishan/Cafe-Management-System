package lk.ijse.dep11.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface DashboardService {
    ResponseEntity<Map<String,Object>> getCount();
}
