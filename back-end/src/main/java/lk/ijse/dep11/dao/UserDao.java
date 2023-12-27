package lk.ijse.dep11.dao;

import lk.ijse.dep11.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
