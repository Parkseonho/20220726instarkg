package com.mysite.sbbb.board.controller;

import com.mysite.sbbb.board.BoardForm;
import com.mysite.sbbb.board.BoardService;
import com.mysite.sbbb.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/board")
@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/list")
    public String showBoard(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Board> paging = this.boardService.getList(page);
        model.addAttribute("paging",paging);
        return "user/board";
    }

    @GetMapping("/page")
    public String boardPage(BoardForm boardForm){
        return "user/boardwrite";
    }

    @PostMapping("/page")
    public String boardPageWrite(Board board, MultipartFile file)throws Exception{
      boardService.write(board, file);

      return "user/board";
    }

/*
    @RequestMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Board board = this.boardService.getBoard(id);
        boardService.updateHit(id);
        model.addAttribute("board", board);
        return "user/board_detail";
    }
*/
}
