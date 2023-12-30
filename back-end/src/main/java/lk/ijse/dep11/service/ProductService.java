package lk.ijse.dep11.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductService {
    ResponseEntity<String> addNewProduct(Map<String,String> requestMap);
}
