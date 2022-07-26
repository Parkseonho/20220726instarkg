package com.mysite.sbbb.board.controller;

import com.mysite.sbbb.board.BoardForm;
import com.mysite.sbbb.board.BoardService;
import com.mysite.sbbb.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/board")
@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/page")
    public String boardPage(BoardForm boardForm){
        return "user/boardwrite";
    }

    @PostMapping("/page")
    public String boardWritepro(Board board, MultipartFile file)throws Exception{
      boardService.write(board, file);

      return "user/question";
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board, MultipartFile file) throws Exception{
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp, file);

        return "redirect:/question/list";
    }


}
