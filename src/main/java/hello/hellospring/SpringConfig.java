package hello.hellospring;

import hello.hellospring.service.MemberService;
import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 하단의 Spring Bean 등록
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    // spring data jpa가 만들어놓은 구현체에 injection 된다.
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        // JpaRepository를 상속받은 interface의 구현체를 스프링빈에 등록해 둠.
        this.memberRepository = memberRepository;
    }

    //    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    //    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // 직접 스프링 빈 등록 물론 @Component로 스캔해도 된다.
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository()
//    {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}
