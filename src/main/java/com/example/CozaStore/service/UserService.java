package com.example.CozaStore.service;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.exception.CustomException;
import com.example.CozaStore.payload.request.SignupRequest;
import com.example.CozaStore.payload.response.UserResponse;
import com.example.CozaStore.repository.UserRepository;
import com.example.CozaStore.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignupRequest request) {


        try{
            if (userRepository.findByEmail(request.getEmail()) != null) {
               return false;
            }
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            userRepository.save(user);
            return true;
        }catch (Exception e){
                throw new CustomException("Email already exist" + e.getMessage());
        }



    }

    @Override
    public UserResponse getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        UserResponse userResponse = new UserResponse(user.getId(), user.getEmail(), user.getUsername());
        return userResponse;
    }

    @Override
    public UserResponse getUserById(int userId) {
        UserEntity userEntity = userRepository.findUserById(userId);
        UserResponse userResponse = new UserResponse(userEntity.getId(), userEntity.getEmail(), userEntity.getUsername());
        return userResponse;
    }
}
