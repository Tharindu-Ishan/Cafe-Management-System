package lk.ijse.dep11.restImpl;

import lk.ijse.dep11.constants.CafeConstants;
import lk.ijse.dep11.rest.CategoryRest;
import lk.ijse.dep11.service.CategoryService;
import lk.ijse.dep11.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CategoryRestIml implements CategoryRest {
    @Autowired
    CategoryService categoryService;
    @Override
    public ResponseEntity addNewCategory(Map<String, String> requestMap) {
        try{
            return categoryService.addNewCategory(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
