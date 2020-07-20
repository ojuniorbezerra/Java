package com.envies.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.envies.listener.RevisaoListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@RevisionEntity(value = RevisaoListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Revisao {
	
	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "revisao_Sequence")
    @SequenceGenerator(name = "revisao_Sequence", sequenceName = "REVISAO_SEQ")
    @RevisionNumber
    private Long revisaoId;

    @RevisionTimestamp
    private Date revisaoData;

    @Column
    private String ip;

    @Column
    private String usuario;
}
