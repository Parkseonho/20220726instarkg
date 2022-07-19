package com.mysite.sbbb.answer.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mysite.sbbb.question.domain.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Answer {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
<<<<<<< Updated upstream

    private Boolean replyLike;

=======
>>>>>>> Stashed changes
    @ManyToOne
    private Question question;
    @Converter
    class BooleanToYNConverter implements AttributeConverter<Boolean, String>{
        @Override
        public String convertToDatabaseColumn(Boolean attribute){
            return (attribute != null && attribute) ? "Y" : "N";
        }

        @Override
        public Boolean convertToEntityAttribute(String dbData){
            return "Y".equals(dbData);
        }
    }

}