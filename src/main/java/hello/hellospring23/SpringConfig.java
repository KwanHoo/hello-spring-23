package hello.hellospring23;

import hello.hellospring23.repository.MemberRepository;
import hello.hellospring23.repository.MemoryMemberRepository;
import hello.hellospring23.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 자바코드로 직접 스프링 빈 등록
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());    //에러뜸
        return new MemberService((MemoryMemberRepository) memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
