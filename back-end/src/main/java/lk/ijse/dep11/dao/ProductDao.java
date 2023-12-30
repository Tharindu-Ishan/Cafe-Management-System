package lk.ijse.dep11.dao;

import lk.ijse.dep11.POJO.Product;
import lk.ijse.dep11.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    List<ProductWrapper> getAllProduct();

}
