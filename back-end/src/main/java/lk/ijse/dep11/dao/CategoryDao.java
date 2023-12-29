package lk.ijse.dep11.dao;

import lk.ijse.dep11.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    List<Category> getAllCategory();
}
