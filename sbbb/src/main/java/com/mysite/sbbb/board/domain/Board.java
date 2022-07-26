package com.mysite.sbbb.board.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mysite.sbbb.boardAnswer.domain.boardAnswer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
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

    private Boolean replyLike;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<boardAnswer> boardAnswerList;

    @Converter
    class BooleanToYNConverter implements AttributeConverter<Boolean, String>{
        @Override
        public String convertToDatabaseColumn(Boolean attribute){
            return (attribute != null&& attribute) ? "Y" : "N";
        }

        @Override
        public Boolean convertToEntityAttribute(String dbData){
            return "Y".equals(dbData);
        }
    }
}