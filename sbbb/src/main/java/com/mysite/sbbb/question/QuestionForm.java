package com.mysite.sbbb.question;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "이미지 삽입 必")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내용 입력 必")
    private String content;
}
