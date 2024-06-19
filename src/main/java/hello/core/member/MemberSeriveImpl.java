package hello.core.member;

public class MemberSeriveImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private  MemberRepository memberRepository;

    public MemberSeriveImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
