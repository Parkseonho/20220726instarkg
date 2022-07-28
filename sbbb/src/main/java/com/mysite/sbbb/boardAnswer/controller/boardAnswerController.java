package com.mysite.sbbb.boardAnswer.controller;

import com.mysite.sbbb.board.BoardService;
import com.mysite.sbbb.board.domain.Board;
import com.mysite.sbbb.boardAnswer.boardAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/boardAnswer")
@RequiredArgsConstructor
@Controller
public class boardAnswerController {
    private final BoardService boardService;
    private final boardAnswerService boardAnswerService;

    @PostMapping("/create/{id}")
    public String createBoardAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        Board board = this.boardService.getBoard(id);
        this.boardAnswerService.create(board, content);
        return String.format("redirect:/board/detail/%s", id);
    }

    @PostMapping("/create/{boardId}/{boardAnswerId}")
    public String createBoardAnswer(@PathVariable("boardId") Integer boardId, @PathVariable("boardAnswerId") Integer boardAnswerId) {
        this.boardAnswerService.setLike(boardAnswerId);

        return String.format("redirect:/board/detail/%s", boardId);
    }

}
