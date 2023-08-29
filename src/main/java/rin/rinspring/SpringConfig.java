package rin.rinspring;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rin.rinspring.repository.JpaMemberRepository;
import rin.rinspring.repository.MemberRepository;
import rin.rinspring.repository.MemoryMemberRepository;
import rin.rinspring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        return new JpaMemberRepository(em);
    }
}
