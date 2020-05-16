package com.example.FinalYearProject.Online.Coding.Platform.Security;

public class AuthenticationFacade {
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
