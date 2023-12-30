package lk.ijse.dep11.rest;

import lk.ijse.dep11.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/product")
public interface ProductRest {
    @PostMapping("/add")
    ResponseEntity<String> addNewProduct(@RequestBody Map<String,String> requestMap);
    @GetMapping("/get")
    ResponseEntity<List<ProductWrapper>> getAllProduct();
    @PostMapping("/update")
    ResponseEntity<String> upDateProduct(@RequestBody Map<String,String> requestMap);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable Integer id);
    @PostMapping("/updateStatus")
    ResponseEntity<String> updateStatus(@RequestBody Map<String,String> requestMap);
    @GetMapping("/getByCategory/{id}")
    ResponseEntity<List<ProductWrapper>> getByCategory(@PathVariable Integer id);
    @GetMapping("/getById/{id}")
    ResponseEntity<ProductWrapper> getProductById(@PathVariable Integer id);
}

