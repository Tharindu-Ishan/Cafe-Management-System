package lk.ijse.dep11.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/product")
public interface ProductRest {
    @PostMapping("/add")
    ResponseEntity<String> addNewProduct(@RequestBody Map<String,String> requestMap);
}
