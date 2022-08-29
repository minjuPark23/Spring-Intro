package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 상속받으면 스프링이 스프링 빈에 자동 등록 해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL: SELECT m FROM Member m WHERE m.name = ?으로 번역
    // interface 이름만으로 해결된다.
    @Override
    Optional<Member> findByName(String name);
}
