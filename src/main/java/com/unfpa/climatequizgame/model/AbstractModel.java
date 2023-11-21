package com.unfpa.climatequizgame.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractModel implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @CreatedDate
    @Column(name = "create_date")
    private Instant createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private Instant UpdateDate;

    private boolean status;
}
