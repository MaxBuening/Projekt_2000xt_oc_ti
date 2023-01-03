package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserLoginRequest;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PutMapping(path = "/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserManipulationRequest request){
        var user = userService.update(id, request);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Void> createUser(@RequestBody UserManipulationRequest request) throws URISyntaxException {
        var user = userService.create(request);
        URI uri = new URI("/api/user/" + user.getId());
        return ResponseEntity.created(uri).build();
    }


    @PostMapping(path = "/login")
    public ResponseEntity<String> login (@RequestBody UserLoginRequest loginRequest, HttpServletResponse response){
     var login = userService.login(loginRequest.getBenutzername(),loginRequest.getPasswort());

        Cookie cookie = new Cookie("refresh-token",login.getRefreshToken().getToken());
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        cookie.setPath("/api");
        response.addCookie(cookie);

     return login != null ? ResponseEntity.ok(login.getAccessSecret().getToken()) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/user")
    public ResponseEntity<User> benutzer (HttpServletRequest request){
        var user = (User) request.getAttribute("user");
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        boolean succes = userService.deleteById(id);
        return succes ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/refresh")
    public ResponseEntity<String> refresh(@CookieValue("refresh-token") String refreshToken){
        return ResponseEntity.ok(userService.refreshAccess(refreshToken).getAccessSecret().getToken());
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<String> logout(HttpServletResponse response){
        Cookie cookie = new Cookie("refresh-token",null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return ResponseEntity.ok("Ausgeloggt");
    }
}
