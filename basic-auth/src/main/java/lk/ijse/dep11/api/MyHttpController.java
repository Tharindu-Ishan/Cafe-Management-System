package lk.ijse.dep11.api;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class MyHttpController {

    @GetMapping
    public String getAllCustomers(){
        return "<h1>Get all customers<h1>";
    }
    @PostMapping
    public String saveCustomer(){
        return "Save customer";
    }

}
