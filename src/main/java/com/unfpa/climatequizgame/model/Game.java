package com.unfpa.climatequizgame.model;

import jakarta.persistence.Entity;
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
@Table(name="game")
public class Game extends AbstractModel{

    private Long idAdmin;

    private Long idTeam1;

    private Long idTeam2;
}
