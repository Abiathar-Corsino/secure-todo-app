package com.team.secure_todo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthFailureListener {
    private static final Logger logger = LoggerFactory.getLogger(AuthFailureListener.class);

    @EventListener
    public void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event) {
        logger.warn("Bad login try by: {}", event.getAuthentication().getName());
    }
}

