package com.mysite.sbbb.board;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BoardForm {
    @NotEmpty(message = "내용은 필수")
    private String content;
}
