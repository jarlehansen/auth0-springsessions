package com.example.sso;

import com.auth0.web.Auth0Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    @Autowired
    private Auth0Config auth0Config;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected String logout(final HttpServletRequest request) {
        invalidateSession(request);
        final String logoutPath = auth0Config.getOnLogoutRedirectTo();
        return "redirect:" + logoutPath;
    }

    private void invalidateSession(HttpServletRequest request) {
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
    }
}
