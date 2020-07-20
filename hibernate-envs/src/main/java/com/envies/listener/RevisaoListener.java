package com.envies.listener;

import org.hibernate.envers.RevisionListener;

import com.envies.model.Revisao;

public class RevisaoListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {

		Revisao revisao = (Revisao) revisionEntity;
		
		
	}

}
