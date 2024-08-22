package guide_book.KTO_public_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String MainPage() {
        return "main";
    }

    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }
}
