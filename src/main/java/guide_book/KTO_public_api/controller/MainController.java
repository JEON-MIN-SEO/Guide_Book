package guide_book.KTO_public_api.controller;

import guide_book.KTO_public_api.dto.UserDTO;
import guide_book.KTO_public_api.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private JoinService joinService;

    public MainController (JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/")
    public String MainPage() {
        return "main";
    }

    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }

    @GetMapping("/join")
    public String JoinPage() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String JoinProcess(UserDTO userDTO) {
        //もし加入が失敗した場合またjoinPageに戻す例外処理が必要



        joinService.JoinProcess(userDTO);
        return "redirect:/login";
    }
}
