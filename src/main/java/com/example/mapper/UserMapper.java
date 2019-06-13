package com.example.mapper;

import com.example.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserVO Sel(int id);
}
