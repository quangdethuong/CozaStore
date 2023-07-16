package com.example.CozaStore.service;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.exception.CustomException;
import com.example.CozaStore.payload.request.SignupRequest;
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
        boolean isSuccess = false;
        try{
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e){
                throw new CustomException("Loi add user" + e.getMessage());
        }


        return isSuccess;
    }
}
