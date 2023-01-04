package com.lsk.myapp.service;

import com.lsk.myapp.domain.UserDTO;

public interface MemberService {
    UserDTO selectUser(String id);
    int register(UserDTO userDTO);
}
