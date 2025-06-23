package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Log4j2
@RequestMapping("/security")
@Controller
public class SecurityController {
    @GetMapping("/all")     // 모두 접근 가능
    public void doAll() {
        log.info("doAll can access everybody");
    }

    @GetMapping("/member")  // MEMBER 또는 ADMIN 권한 필요
    public void doMember(Principal principal) {
        log.info("username = " + principal.getName());
    }

    @GetMapping("/admin")
    public void doAdmin() {
        log.info("admin only");
    }

    @GetMapping("/login")
    public void login() {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }

}
