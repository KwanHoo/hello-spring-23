package hello.hellospring23;

import hello.hellospring23.repository.JdbcMemberRepository;
import hello.hellospring23.repository.JdbcTemplateMemberRepository;
import hello.hellospring23.repository.MemberRepository;
import hello.hellospring23.repository.MemoryMemberRepository;
import hello.hellospring23.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


// 자바코드로 직접 스프링 빈 등록
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());    //에러뜸
        return new MemberService((MemoryMemberRepository) memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);    // 에러뜸
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
