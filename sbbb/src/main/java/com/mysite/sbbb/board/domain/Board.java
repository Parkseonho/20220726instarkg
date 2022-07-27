package com.mysite.sbbb.board.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Board {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private String filename;

    private String filepath;

    private LocalDateTime createDate;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private Integer hit;
}