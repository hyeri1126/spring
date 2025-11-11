package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository membberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        membberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return membberRepository.findById(memberId);
    }
}
