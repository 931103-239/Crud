package com.lsk.myapp.service;

import com.lsk.myapp.domain.BoardDTO;
import com.lsk.myapp.domain.SearchCondition;

import java.util.List;

public interface BoardService {
    int getCount();
    List<BoardDTO> getList();
    int write(BoardDTO boardDTO);
    BoardDTO read(Integer bno);
    int modify(BoardDTO boardDTO);
    int remove(Integer bno, String writer);
    //  ========================================
    int getSearchResultCnt(SearchCondition sc); // getCount + sc
    List<BoardDTO> getSearchResultPage(SearchCondition sc); // getList + sc
}
