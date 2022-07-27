package com.mysite.sbbb.board;

import com.mysite.sbbb.DataNotFoundException;
import com.mysite.sbbb.board.dao.BoardRepository;
import com.mysite.sbbb.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        board.setFilename(fileName);

        board.setFilepath("/files/" + fileName);

        board.setCreateDate(LocalDateTime.now());

        board.setReplyLike(false);

        boardRepository.save(board);
    }

    public void setLike(Integer id){
        Board board = boardRepository.findById(id).get();
        if(board.getReplyLike()==true){
            board.setReplyLike(false);
        }else {
            board.setReplyLike(true);
        }
        this.boardRepository.save(board);
    }

    public List<Board> getList(){
        return boardRepository.findAll();
    }

    public Page<Board> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.boardRepository.findAll(pageable);
    }
    public Board getBoard(Integer id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if(board.isPresent()){
            return board.get();
        }else {
            throw new DataNotFoundException("board not found");
        }
    }

     public void updateHit(Integer id) {
        Board board = getBoard(id);
        int count = board.getHit();
         board.setHit(count+1);
        boardRepository.save(board);
    }
}
