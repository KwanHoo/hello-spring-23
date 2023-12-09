package hello.hellospring23.repository;

import hello.hellospring23.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);         //optional을 자바 8에 들어간 기능. findById값이 없으면  null로 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
