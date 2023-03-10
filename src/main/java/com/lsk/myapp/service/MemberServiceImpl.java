package com.lsk.myapp.service;

import com.lsk.myapp.dao.UserDAO;
import com.lsk.myapp.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDTO selectUser(String id)  { return userDAO.select(id); }

    @Override
    public int register(UserDTO userDTO) { return userDAO.insert(userDTO); }
}
