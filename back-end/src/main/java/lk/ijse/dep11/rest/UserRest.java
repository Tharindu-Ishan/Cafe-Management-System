package lk.ijse.dep11.rest;

import lk.ijse.dep11.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RequestMapping(path = "/user")
public interface UserRest {
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String,String> requestMap);
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String,String> requestMap);
    @GetMapping(path = "/get")
    public ResponseEntity<List<UserWrapper>> getAllUser();
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody(required = true) Map<String ,String> requestMap);
    @GetMapping("/checkToken")
    ResponseEntity<String> checkToken();
}
