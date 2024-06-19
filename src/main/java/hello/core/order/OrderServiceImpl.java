package hello.core.order;

import hello.core.discount.DIscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl  implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DIscountPolicy dIscountPolicy = new FixDiscountPolicy(); DIP, OCP 위반
    private final MemberRepository memberRepository;
    private final DIscountPolicy dIscountPolicy; //DIP를 지킴

    public OrderServiceImpl(MemberRepository memberRepository, DIscountPolicy dIscountPolicy) {
        this.memberRepository = memberRepository;
        this.dIscountPolicy = dIscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = dIscountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
