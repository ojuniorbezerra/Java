package com.envies.model;

import javax.persistence.Entity;

import org.hibernate.envers.RevisionEntity;

import com.envies.listener.RevisaoListener;

@Entity
@RevisionEntity(value = RevisaoListener.class)
public class Revisao {

}
