package rin.rinspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rin.rinspring.repository.MemberRepository;
import rin.rinspring.repository.MemoryMemberRepository;
import rin.rinspring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
