package com.mysite.sbbb.board;

import com.mysite.sbbb.board.dao.BoardRepository;
import com.mysite.sbbb.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board, MultipartFile file)throws Exception{
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files" ;

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        boardRepository.save(board);
    }

    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }
}
