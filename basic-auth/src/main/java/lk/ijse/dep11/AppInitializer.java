package lk.ijse.dep11;

import io.jsonwebtoken.Jwts;
import lk.ijse.dep11.secuirity.SecurityInterceptor;
import lk.ijse.dep11.secuirity.SecurityInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.crypto.SecretKey;

@SpringBootApplication
public class AppInitializer implements WebMvcConfigurer {
    @Autowired
    private SecurityInterceptor2 securityInterceptor2;
    @Bean
    public SecretKey secretKey(){
        return Jwts.SIG.HS256.key().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptor());
        registry.addInterceptor(new SecurityInterceptor2());
    }
}
