package com.lsk.myapp.dao;

import com.lsk.myapp.domain.UserDTO;

public interface UserDAO {
    UserDTO select(String id);
    int insert(UserDTO userDTO);
}
