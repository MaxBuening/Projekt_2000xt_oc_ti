package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/api/user/{id}")
    public ResponseEntity<User> userById(@PathVariable Long id){
        var user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserManipulationRequest request){
        var user = userService.update(id, request);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/user")
    public ResponseEntity<Void> createUser(@RequestBody UserManipulationRequest request) throws URISyntaxException {
        var user = userService.create(request);
        URI uri = new URI("/api/user/" + user.getId());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/api/user/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        boolean succes = userService.deleteById(id);
        return succes ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
