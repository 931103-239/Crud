package com.lsk.myapp.service;

import com.lsk.myapp.dao.BoardDAO;
import com.lsk.myapp.domain.BoardDTO;
import com.lsk.myapp.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDAO;

    @Override
    public int getCount(){
        return boardDAO.count();
    }

    @Override
    public List<BoardDTO> getList() {
        return boardDAO.selectAll();
    }

    @Override
    public int write(BoardDTO boardDTO) { return boardDAO.insert(boardDTO); }

    @Override
    public BoardDTO read(Integer bno) {
        BoardDTO boardDTO = boardDAO.select(bno);
        boardDAO.increaseViewCnt(bno);
        return boardDTO;
    }

    @Override
    public int modify(BoardDTO boardDTO) { return boardDAO.update(boardDTO); }

    @Override
    public int remove(Integer bno, String writer) {
        return boardDAO.delete(bno, writer);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc){
        return boardDAO.searchResultCnt(sc);
    }

    public List<BoardDTO> getSearchResultPage(SearchCondition sc){
        return boardDAO.searchSelectPage(sc);
    }

}
