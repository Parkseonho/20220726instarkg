package com.mysite.sbbb.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id

    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer boardIdx;

    @NotEmpty
    private String original_file_name;

    @NotEmpty
    private String stored_file_path;

    private long file_size;

}