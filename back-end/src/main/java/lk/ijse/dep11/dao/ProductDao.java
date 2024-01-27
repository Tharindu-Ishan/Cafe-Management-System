package lk.ijse.dep11.dao;

import javax.transaction.Transactional;
import lk.ijse.dep11.POJO.Product;
import lk.ijse.dep11.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    List<ProductWrapper> getAllProduct();
    @Modifying
    @Transactional
    Integer updateProductStatus(@Param("status") String status,@Param("id") Integer id);
    List<ProductWrapper> getProductByCategory(@Param("id")Integer id);
    ProductWrapper getProductById(@Param("id") Integer id);

}
