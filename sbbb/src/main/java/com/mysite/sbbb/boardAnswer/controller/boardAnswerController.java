package com.mysite.sbbb.boardAnswer.controller;

import com.mysite.sbbb.board.BoardService;
import com.mysite.sbbb.board.domain.Board;
import com.mysite.sbbb.boardAnswer.boardAnswerForm;
import com.mysite.sbbb.boardAnswer.boardAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class boardAnswerController {
    private final BoardService boardService;
    private final boardAnswerService boardAnswerService;

    @PostMapping("/create/{id}")
    public String createBoardAnswer(Model model, @PathVariable("id") Integer id, @Valid boardAnswerForm boardAnswerForm, BindingResult bindingResult){
        Board board = this.boardService.getBoard(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("board", board);
            return "user/board_detail";
        }
        this.boardAnswerService.create(board, boardAnswerForm.getContent());
        return String.format("redirect:/board/detail/%s", id);
    }

    @PostMapping("/create/{boardId}/{boardAnswerId}")
    public String createBoardAnswer(@PathVariable("boardId") Integer boardId, @PathVariable("boardAnswerId") Integer boardAnswerId) {
        this.boardAnswerService.setLike(boardAnswerId);

        return String.format("redirect:/board/detail/%s", boardId);
    }

}
