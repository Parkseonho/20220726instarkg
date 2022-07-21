package com.mysite.sbbb.question.service;

import com.mysite.sbbb.DataNotFoundException;
import com.mysite.sbbb.question.dao.QuestionRepository;
import com.mysite.sbbb.question.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public Page<Question> getList(int page){
        Pageable pageable = PageRequest.of(page, 10);
        return this.questionRepository.findAll(pageable);
    }
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content){
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setHit(0);
        question.setCreateDate(LocalDateTime.now());
        questionRepository.save(question);
    }

    public void updateHit(Integer id) {
        Question question = getQuestion(id);
        int count = question.getHit();
        question.setHit(count+1);
        questionRepository.save(question);
    }

}
