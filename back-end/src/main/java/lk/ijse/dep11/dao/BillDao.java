package lk.ijse.dep11.dao;

import lk.ijse.dep11.POJO.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDao extends JpaRepository<Bill,Integer> {
}
