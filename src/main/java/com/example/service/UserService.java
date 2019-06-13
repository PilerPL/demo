package com.example.service;

import com.example.mapper.UserMapper;
import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public UserVO Sel(int id){

        return userMapper.Sel(id);
    }
}
