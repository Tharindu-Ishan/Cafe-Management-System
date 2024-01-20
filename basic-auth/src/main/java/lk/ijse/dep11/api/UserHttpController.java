package lk.ijse.dep11.api;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import lk.ijse.dep11.entity.User;
import lk.ijse.dep11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserHttpController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private SecretKey secretKey;

    @PostMapping(value = "login",consumes = "application/json",produces = "application/json")
    public String login(@RequestBody Map<String,String> credentials){
        String username = credentials.get("username"); //2
        String password = credentials.get("password");
        User user = userRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        if(!user.getPassword().matches(password)) throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.issuer("dep-11");
        jwtBuilder.issuedAt(new java.util.Date());
        LocalDateTime tokenExpTime = LocalDateTime.now().plus(10, ChronoUnit.MINUTES);
        java.util.Date expTime = Date.from(tokenExpTime.toInstant(ZoneOffset.of(ZoneId.systemDefault().getId())));
        jwtBuilder.expiration(expTime);
        jwtBuilder.subject(username);
        jwtBuilder.signWith(secretKey);
        return jwtBuilder.compact();

    }
}
