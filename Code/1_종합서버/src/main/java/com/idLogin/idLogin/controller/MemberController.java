package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.dto.MemberDTO;
import com.idLogin.idLogin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/signup")
    public String signUpForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "signup";
    }

    @PostMapping("/member/signup")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "redirect:/member/login";
    }

    @GetMapping("/member/login")
    public String loginForm(Model model) {
        model.addAttribute("loginFailed", false); // 로그인 실패 여부를 기본값으로 설정
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("user_password") String userPassword, HttpSession session, Model model) {
        String loginResult = memberService.login(userId, userPassword);
        if ("success".equals(loginResult)) {
            session.setAttribute("loginId", userId);
            // login 성공
            return "redirect:/main";
        } else {
            // login 실패
            model.addAttribute("loginFailed", true);
            return "login";
        }
    }

    @GetMapping("/main")
    public String mainForm() {
        return "main";
    }

    @GetMapping("/admin/list")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model사용
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String myId = (String) session.getAttribute("loginId");
        MemberDTO memberDTO = memberService.updateForm(myId);
        model.addAttribute("updateUser", memberDTO);
        return "update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getUser_no();
    }

    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        memberService.deleteById(id); // 데이터베이스에서 회원 삭제
        List<MemberDTO> memberDTOList = memberService.findAll(); // 새로운 목록을 가져옴
        model.addAttribute("memberList", memberDTOList); // 새로운 목록을 모델에 추가
        return "list"; // 삭제가 완료된 목록을 보여주는 페이지(list.html)로 이동
    }

    // 로그아웃 처리 요청
    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화하여 로그아웃 처리
        return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
    }


    @PostMapping("/member/id-check")
    public @ResponseBody String IdCheck(@RequestParam("user_id") String userId) {
        System.out.println("userId = " + userId);
        String checkResult = memberService.IdCheck(userId);
        return checkResult;
//        if (checkResult != null) {
//            return "ok";
//        } else {
//            return "no";
//        }
    }
}
