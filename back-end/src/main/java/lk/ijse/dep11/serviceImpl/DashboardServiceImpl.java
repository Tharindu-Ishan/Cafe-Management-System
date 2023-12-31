package lk.ijse.dep11.serviceImpl;

import lk.ijse.dep11.dao.BillDao;
import lk.ijse.dep11.dao.CategoryDao;
import lk.ijse.dep11.dao.ProductDao;
import lk.ijse.dep11.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    BillDao billDao;
    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("category",categoryDao.count());
        map.put("product",categoryDao.count());
        map.put("bill",categoryDao.count());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
