package lk.ijse.dep11.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils  {
    private CafeUtils() {

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>(responseMessage, httpStatus);
    }
}
