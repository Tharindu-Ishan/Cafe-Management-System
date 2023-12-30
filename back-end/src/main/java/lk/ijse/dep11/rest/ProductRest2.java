package lk.ijse.dep11.rest;

import lk.ijse.dep11.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/product")
public interface ProductRest2 {
    @PostMapping("/add")
    ResponseEntity<String> addNewProduct(@RequestBody Map<String,String> requestMap);
    @GetMapping("/get")
    ResponseEntity<List<ProductWrapper>> getAllProduct();
    @PostMapping("/update")
    ResponseEntity<String> upDateProduct(@RequestBody Map<String,String> requestMap);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable Integer id);
}

