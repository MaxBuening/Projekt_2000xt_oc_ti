package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserCreateRequest;
import Projekt.xt_oc_ti.PEXOCTI.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/user")
    public ResponseEntity<List<User>> user(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(path = "/api/user")
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequest request) throws URISyntaxException {
        var user = userService.create(request);
        URI uri = new URI("/api/user/" + user.getId());
        return ResponseEntity.created(uri).build();
    }
}
