package com.example.sso;

import com.auth0.web.Auth0Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@Controller
public class RedirectErrorController implements ErrorController {
    private static final String PATH = "/error";

    @Autowired
    private Auth0Config auth0Config;

    @RequestMapping("/error")
    protected String error(final RedirectAttributes redirectAttributes) throws IOException {
        final String logoutPath = auth0Config.getOnLogoutRedirectTo();
        redirectAttributes.addFlashAttribute("error", true);
        return "redirect:" + logoutPath;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
