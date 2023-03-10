package in.bushansirgur.expensetrackerapi.controller;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;
import in.bushansirgur.expensetrackerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    전달값 UserMode, 반환값 ResponseEntity
//    @PostMapping("/register")
//    public ResponseEntity<User> save(@Valid @RequestBody UserModel user)
//    {
//        return new ResponseEntity<User>(userService.createUser(user),
//                HttpStatus.CREATED);
////        ResponseEntity - http 응답으로 변환 될 정보를 객체로 반환.
//
//    }
    @GetMapping("/profile")
    public ResponseEntity<User> readUser(){
        return new ResponseEntity<User>(userService.readUser(), HttpStatus.OK);
    }
    @PutMapping("/profile")
    public ResponseEntity<User> updateUser(@RequestBody UserModel user,
                                           @PathVariable Long id){
        return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
    }
    @DeleteMapping("/deactivate")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        userService.deleteUser();
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


}
