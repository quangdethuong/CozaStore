package com.example.CozaStore.controller;


import com.example.CozaStore.exception.CustomException;
import com.example.CozaStore.payload.request.SignupRequest;
import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.UserServiceImp;
import com.example.CozaStore.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserServiceImp userServiceImp;

    /*
    {
        "statusCode" : 200
        "message" : ""
        "data" : kiểu gì cũng được
     }
     */

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ResponseEntity<?> signin(
            @RequestParam String email, @RequestParam String password){

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email,password);
        authenticationManager.authenticate(token);

        String jwt = jwtHelper.generateToken(email);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(jwt);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid SignupRequest request, BindingResult result){
        List<FieldError> list = result.getFieldErrors();
        for (FieldError data: list){
            throw new CustomException(data.getDefaultMessage());
            //System.out.println("Kiem tra " + data.getField() + " - " + data.getDefaultMessage());
        }
        boolean isSuccess = userServiceImp.addUser(request);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
