package lk.ijse.dep11.secuirity;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Incoming Request");
        String autherization = request.getHeader("Autherization"); //1
        if (autherization!=null){
            if(autherization.toUpperCase().startsWith("BASIC")){ //2
                String encodedText = autherization.substring(6);  //3
                byte[] decodedTextBytes = Base64.getDecoder().decode(encodedText); //4
                String decodedText = new String(decodedTextBytes);
                String[] credentials = decodedText.split(":"); //5
                if(credentials.length==2){
                    String username = credentials[0];
                    String password = credentials[1];
                    if(username.equals("ijse")&&password.equals("dep11")){
                        return true;
                    }
                }

            }
        }
        response.sendError(401);
        return false;
    }
}
