package com.lsk.myapp;


import com.lsk.myapp.dao.BoardDAO;
import com.lsk.myapp.domain.BoardDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOImplTest {
    @Autowired
    BoardDAO boardDAO;

    @Test
    public void insertTestData() throws Exception{
        for(int i=1; i<=220; i++){
            BoardDTO boardDTO = new BoardDTO("title" + i, "no content", "holic9311");
            boardDAO.insert(boardDTO);
        }
    }
}