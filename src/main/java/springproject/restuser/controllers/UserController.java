package springproject.restuser.controllers;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.data.domain.PageRequest;import org.springframework.data.domain.Pageable;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import springproject.restuser.models.entity.User;import springproject.restuser.services.IUserService;import java.util.List;@RestController@RequestMapping("/api/user")public class UserController {    @Autowired    private IUserService userService;    @GetMapping("/select")    public ResponseEntity<List<User>> select() {        return ResponseEntity.ok(userService.select("CREATED"));    }    @GetMapping("/select/{page}")    public Page<User> pagination(@PathVariable Integer page) {        Pageable pageable = PageRequest.of(page, 5);        return userService.select("CREATED", pageable);    }    @GetMapping("/get/{id}")    public ResponseEntity<User> get(@PathVariable Long id) {        return ResponseEntity.status(HttpStatus.OK)                .body(userService.get(id));    }    @PostMapping("/insert")    public ResponseEntity<User> insert(@RequestBody User user) {        return ResponseEntity.status(HttpStatus.CREATED)                .body(userService.insert(user));    }    @PutMapping("/update/{id}")    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {        return ResponseEntity.status(HttpStatus.CREATED)                .body(userService.update(user, id));    }    @DeleteMapping("/delete/{id}")    public ResponseEntity<User> delete(@PathVariable Long id) {        return ResponseEntity.status(HttpStatus.OK)                .body(userService.delete(id));    }}