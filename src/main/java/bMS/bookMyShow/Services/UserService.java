package bMS.bookMyShow.Services;

import bMS.bookMyShow.Dtos.UserRequestDto;
import bMS.bookMyShow.Models.UserEntity;
import bMS.bookMyShow.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String  createUser(UserRequestDto userRequestDto){

        //converted userDto to userEntity
        UserEntity user= UserEntity.builder().name(userRequestDto.getName())
                .mobileNo(userRequestDto.getMobileNo()).build();
      try {
          userRepository.save(user);
      }
      catch(Exception e){
            return  "user can not be added";
        }
        return "User added successfully";

    }


    public UserEntity getUserById(int id) {
        try {
            UserEntity user =  userRepository.findById(id).get();
            return user;
        }
        catch(Exception e){
            return null;
        }
    }
    public List<UserEntity> findAllUser(){
        return userRepository.findAll();
    }
}
