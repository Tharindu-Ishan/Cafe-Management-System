package lk.ijse.dep11.dao;

import lk.ijse.dep11.POJO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {

}
