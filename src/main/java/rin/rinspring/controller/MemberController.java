package rin.rinspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import rin.rinspring.service.MemberService;

@Controller //스프링 빈이 관리된다고 표현.
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
}
