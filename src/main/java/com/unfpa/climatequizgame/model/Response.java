package com.unfpa.climatequizgame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="responses")
public class Response extends AbstractModel{

    private String response;

    private Boolean rightOrFalse;

    @ManyToOne
    @JoinColumn(name = "question")
    private Question question;
}
