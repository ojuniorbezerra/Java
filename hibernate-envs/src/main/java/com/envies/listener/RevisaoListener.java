package com.envies.listener;

import org.hibernate.envers.RevisionListener;

import com.envies.model.Revisao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class RevisaoListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {

        Revisao rev = (Revisao)revisionEntity;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        Object details = auth.getDetails();

        if (principal instanceof UserDetails)
            rev.setUsuario(((UserDetails) principal).getUsername());

        if (details instanceof WebAuthenticationDetails)
            rev.setIp(((WebAuthenticationDetails) details).getRemoteAddress());
		
		
	}

}
