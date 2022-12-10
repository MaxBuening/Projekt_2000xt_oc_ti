package Projekt.xt_oc_ti.PEXOCTI.interceptor;

import Projekt.xt_oc_ti.PEXOCTI.Exceptions.NoBearerTokenException;
import Projekt.xt_oc_ti.PEXOCTI.Exceptions.UnauthenticatedException;
import Projekt.xt_oc_ti.PEXOCTI.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Authorizationinterceptor implements HandlerInterceptor {
    private final UserService userService;

    public Authorizationinterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null) {
            throw new UnauthenticatedException();
        }

        if(!authorizationHeader.startsWith("Bearer ")) throw new NoBearerTokenException();

        request.setAttribute("user", userService.getBenutzerFromToken(authorizationHeader.substring(7)));

        return true;
    }
}
