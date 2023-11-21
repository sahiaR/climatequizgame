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
@Table(name="players")
public class Players extends AbstractModel{

    private String nom;

    private int age;

    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;
}
