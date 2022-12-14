package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 추상 메소드
    Member save(Member member);
    Optional<Member> findById(Long id);
    //null을 반환할 때 optional로 감싸서 반환 (java8)
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
