package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm(){
        System.out.println("SpringMemberFormControllerV1.process");
        return new ModelAndView("/WEB-INF/views/new-form.jsp");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        // 인자로 Model 정보 받아옴
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView modelView = new ModelAndView("/WEB-INF/views/save-result.jsp");
        modelView.addObject("memberId", member);
        return modelView;
    }

    @RequestMapping
    public ModelAndView members(){
        List<Member> members = memberRepository.findAll();

        ModelAndView modelView = new ModelAndView("/WEB-INF/views/members.jsp");
        modelView.addObject("members", members);

        return modelView;
    }


}
