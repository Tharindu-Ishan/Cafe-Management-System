package lk.ijse.dep11.secuirity;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
@Component
public class SecurityInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String endPoint = request.getServletPath();
        if(endPoint.equalsIgnoreCase("/api/v1/users/login")) return true;

        String authorization = request.getHeader("Authorization");
        if(authorization!=null)
        response.sendError(401);
        return false;
    }
}
