package com.mysite.sbbb.board.dao;

import com.mysite.sbbb.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
