package hello.core.Singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureConteiner() {
        AppConfig appConfig = new AppConfig();
        //1. 호출할때마다 객체 생성
        MemberService memberService = appConfig.memberService();

        //2. 호출할때마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletoneService instance1 = SingletoneService.getInstance();
        SingletoneService instance2 = SingletoneService.getInstance();

        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 싱글톤 테스트")
    void springContainer(){
//        AppConfig appConfigg = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 호출할때마다 객체 생성
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //2. 호출할때마다 객체 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isSameAs(memberService2);
    }
}
