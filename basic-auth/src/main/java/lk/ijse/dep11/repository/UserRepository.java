package lk.ijse.dep11.repository;

import lk.ijse.dep11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository implements JpaRepository<User,String> {
}
