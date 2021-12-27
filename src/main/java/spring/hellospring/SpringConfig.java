package spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.hellospring.repository.JdbcMemberRepository;
import spring.hellospring.repository.MemberRepository;
import spring.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
