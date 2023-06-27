package com.example.aop;

import com.example.aop.dto.ResponseDto;
import com.example.aop.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j @RestController
@RequiredArgsConstructor
public class AopController {
    @PostMapping("/users")
    public ResponseDto addUser(@RequestBody UserDto user) {
        log.info(user.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("addUser");
        return response;
    }
}
