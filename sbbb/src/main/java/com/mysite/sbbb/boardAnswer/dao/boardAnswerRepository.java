package com.mysite.sbbb.boardAnswer.dao;

import com.mysite.sbbb.boardAnswer.domain.boardAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface boardAnswerRepository extends JpaRepository<boardAnswer, Integer> {
}
