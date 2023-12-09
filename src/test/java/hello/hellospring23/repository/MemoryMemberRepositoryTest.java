package hello.hellospring23.repository;

import hello.hellospring23.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;    // 스태틱 임포트

class MemoryMemberRepositoryTest {
    MemoryMemberRepository reposiroty = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        reposiroty.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("spring");       // ctrl + shift + enter 아래줄 이동

        //when
        reposiroty.save(member);

        //then
        Member result = reposiroty.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);
//        Assertions.assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(result);           // 윗줄 스태틱 임포트 이용
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        reposiroty.save(member1);

        Member member2 = new Member();      // tip) shift + F6 하면 이름 변경 가능
        member2.setName("spring2");
        reposiroty.save(member2);

        //when
        Member result = reposiroty.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        //given
        Member memebe1 = new Member();
        memebe1.setName("spring1");
        reposiroty.save(memebe1);

        Member memebe2 = new Member();
        memebe2.setName("spring2");
        reposiroty.save(memebe2);

        //when
        List<Member> result = reposiroty.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }


}
