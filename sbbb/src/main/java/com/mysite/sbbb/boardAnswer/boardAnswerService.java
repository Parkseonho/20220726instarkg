package com.mysite.sbbb.boardAnswer;

import com.mysite.sbbb.board.domain.Board;
import com.mysite.sbbb.boardAnswer.dao.boardAnswerRepository;
import com.mysite.sbbb.boardAnswer.domain.boardAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class boardAnswerService {
    private final boardAnswerRepository boardAnswerRepository;

    public void create(Board board, String content){
        boardAnswer boardAnswer = new boardAnswer();
        boardAnswer.setContent(content);
        boardAnswer.setCreateDate(LocalDateTime.now());
        boardAnswer.setBoard(board);
        this.boardAnswerRepository.save(boardAnswer);
    }

    public void setLike(Integer boardAnswerId) {
        boardAnswer boardAnswer = boardAnswerRepository.findById(boardAnswerId).get();
        if(boardAnswer.getReplyLike() == true) {
            boardAnswer.setReplyLike(false);
        } else {
            boardAnswer.setReplyLike(true);
        }
        this.boardAnswerRepository.save(boardAnswer);
    }
}
