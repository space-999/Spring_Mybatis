package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    int count() throws Exception;

    int deleteAll();
    int delete(Integer bno, String writer) throws Exception;

    int insert(BoardDto dto) throws Exception;

    List<BoardDto> selectAll() throws Exception;
    BoardDto select(int bno) throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception;

    int update(BoardDto dto) throws Exception;

    int increaseViewCnt(Integer bno) throws Exception;

    int updateCommentCnt(Integer bno, int cnt) throws Exception;
}
