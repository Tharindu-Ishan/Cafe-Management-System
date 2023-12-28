package lk.ijse.dep11.JWT;

import lk.ijse.dep11.POJO.User;
import lk.ijse.dep11.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    private User userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername{}",username);
        userDetail=userDao.findByEmailId(username);
        if(!Objects.isNull(userDetail)){
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(),userDetail.getPassword(),new ArrayList<>());

        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public User getUserDetail(){
        User user=userDetail;
        user.setPassword(null);
        return user;
    }
}
