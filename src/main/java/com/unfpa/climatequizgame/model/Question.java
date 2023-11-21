package com.unfpa.climatequizgame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="questions")
public class Question extends AbstractModel{

    private String question;

    private CategoryGame category;

    @OneToMany(mappedBy = "question")
    private List<Response> responseList;
}
