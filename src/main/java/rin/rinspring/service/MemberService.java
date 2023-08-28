package rin.rinspring.service;

import org.springframework.stereotype.Service;
import rin.rinspring.domain.Member;
import rin.rinspring.repository.MemberRepository;
import rin.rinspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
        public Long join(Member member) {
        //같은이름이 있는 중복회원은 안됨 - 예로 비즈니스로직으로 잡음
        validateDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId(); //임의로 아이디 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
          /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });*/
    }

    /**
     * 전체회원 조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
