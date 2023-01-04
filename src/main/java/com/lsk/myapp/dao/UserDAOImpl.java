package com.lsk.myapp.dao;

import com.lsk.myapp.domain.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SqlSession session;
    private static String user = "com.lsk.myapp.dao.UserMapper.";

    @Override
    public UserDTO select(String id) { return session.selectOne(user + "select", id); }

    @Override
    public int insert(UserDTO userDTO) {
        return session.insert(user + "insert", userDTO);
    }
}
