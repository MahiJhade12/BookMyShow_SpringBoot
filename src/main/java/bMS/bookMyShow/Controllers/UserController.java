package bMS.bookMyShow.Controllers;


import bMS.bookMyShow.Dtos.MovieRequestDto;
import bMS.bookMyShow.Dtos.UserRequestDto;
import bMS.bookMyShow.Models.UserEntity;
import bMS.bookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody  UserRequestDto userRequestDto){
       return  userService.createUser(userRequestDto);

    }

    @GetMapping("/getUser")
    public UserEntity findUser(@RequestParam("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUser")
    public List<UserEntity> findAllUser(){
        return userService.findAllUser();
    }
}
