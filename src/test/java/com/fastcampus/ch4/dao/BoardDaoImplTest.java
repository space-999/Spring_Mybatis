package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void select() throws Exception {
        assertTrue(boardDao != null);
        System.out.println("boardDao = " + boardDao);

        BoardDto boardDto = boardDao.select(30);
        System.out.println("boardDto = " + boardDto);
        assertTrue(boardDto.getBno().equals(30));
    }

    @Test
    public void countTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count() == 0);

        BoardDto boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.count() == 1);

        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.count() == 2);
    }

    @Test
    public void deleteAllTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count() == 0);

        BoardDto boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.deleteAll()==1);
        assertTrue(boardDao.count() == 0);

        boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.deleteAll()==2);
        assertTrue(boardDao.count() == 0);
    }

    @Test
    public void deleteTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count() == 0);

        BoardDto boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);
        Integer bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
        assertTrue((boardDao.count() == 0));

        assertTrue(boardDao.insert(boardDto) == 1);
        bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.delete(bno, boardDto.getWriter()+"222")==0);
        assertTrue((boardDao.count() == 1));

        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
        assertTrue((boardDao.count() == 0));

        assertTrue(boardDao.insert(boardDto)==1);
        bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.delete(bno+1, boardDto.getWriter())==0);
        assertTrue((boardDao.count() == 1));
    }

    @Test
    public void insertTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);

        boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.count() == 2);

        boardDao.deleteAll();
        boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);
        assertTrue(boardDao.count() == 1);
    }

    @Test
    public void selectAllTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count() == 0);

        List<BoardDto> list = boardDao.selectAll();
        assertTrue(list.size() == 0);

        BoardDto boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);

        list = boardDao.selectAll();
        assertTrue(list.size() == 1);

        assertTrue(boardDao.insert(boardDto) == 1);
        list = boardDao.selectAll();
        assertTrue(list.size() == 2);
    }

    @Test
    public void selectTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count() == 0);

        BoardDto boardDto = new BoardDto("no title", "no content", "qwer");
        assertTrue(boardDao.insert(boardDto) == 1);

        Integer bno = boardDao.selectAll().get(0).getBno();
        boardDto.setBno(bno);
        BoardDto boardDto2 = boardDao.select(bno);
        assertTrue(boardDto.equals(boardDto2));
    }

}