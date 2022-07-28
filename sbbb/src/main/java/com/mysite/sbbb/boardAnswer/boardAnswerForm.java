package com.mysite.sbbb.boardAnswer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class boardAnswerForm {
    @NotEmpty(message = "내용은 필수")
    private String content;
}
