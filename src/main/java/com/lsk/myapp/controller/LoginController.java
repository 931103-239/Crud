package com.lsk.myapp.controller;

import com.lsk.myapp.domain.UserDTO;
import com.lsk.myapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import validaotr.UserValidator;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberService ms;

    @InitBinder
    public void toDate(WebDataBinder binder){
        ConversionService conversionService = binder.getConversionService();
        binder.setValidator(new UserValidator()); // UserValidator를 WebDataBinder의 로컬 validator로 등록
    }

    @GetMapping("/join") // 회원가입 페이지
    public String add() { return "register"; }

    @PostMapping("/join") // 회원가입 버튼을 눌렀을 때
    public String save(@Valid UserDTO user, BindingResult result, RedirectAttributes rattr) {
        if(result.hasErrors()) { return "register"; }

        try {
            int check = ms.register(user);
            rattr.addFlashAttribute("msg", "JOIN_OK");

            if (check != 1)
                throw new Exception("Join Failed");

            return "redirect:/login/login";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "JOIN_ERR");
            return "redirect:/login/join";
        }
    }
} // MemberController