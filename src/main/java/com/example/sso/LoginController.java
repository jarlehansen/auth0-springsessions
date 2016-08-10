package com.example.sso;

import com.auth0.web.Auth0Config;
import com.auth0.web.NonceUtils;
import com.auth0.web.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private Auth0Config auth0Config;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    protected String login(final Map<String, Object> model, final HttpServletRequest req) {
        detectError(model);
        NonceUtils.addNonceToStorage(req);
        model.put("clientId", auth0Config.getClientId());
        model.put("domain", auth0Config.getDomain());
        model.put("loginCallback", auth0Config.getLoginCallback());
        model.put("state", SessionUtils.getState(req));
        return "login";
    }

    private void detectError(final Map<String, Object> model) {
        boolean hasError = model.get("error") == null;
        model.put("error", hasError);
    }
}
