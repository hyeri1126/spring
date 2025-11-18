package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // 임의의 테스트 클래스 생성
    static class TestBean {

        // Member는 스프링이 관리하고 있는 스프링 빈이 아니다.
        // 그러나 required가 false라서 setNobean1 메서드 자체가 호출되지 않아서
        // 에러가 발생하지 않는다.
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("setNoBean1 = " + member);
        }

        // @Nullable은 자동 주입할 대상이 없으면 null이 입력된다
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " + member);
        }

        // Opional은 자동 주입할 대상이 없은 Optional.empty가 입력된다.
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " + member);
        }

    }
}
