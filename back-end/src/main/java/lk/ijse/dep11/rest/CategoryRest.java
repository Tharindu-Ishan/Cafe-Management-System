package lk.ijse.dep11.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/category")
public interface CategoryRest {
    @PostMapping("add")
    ResponseEntity addNewCategory(@RequestBody Map<String,String> requestMap);
}
