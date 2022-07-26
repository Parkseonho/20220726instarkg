package com.mysite.sbbb.board.controller;

import com.mysite.sbbb.board.BoardForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {
    @GetMapping("/page")
    public String boardPage(BoardForm boardForm){
        return "user/boardwrite";
    }




}
