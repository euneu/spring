package hello.core;

import hello.core.discount.DIscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberSeriveImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.order.RateDiscountPolicy;

public class AppConfig {

    public MemberService memberService() {
        return new MemberSeriveImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), dIscountPolicy());
    }

    public DIscountPolicy dIscountPolicy(){
        return new RateDiscountPolicy();
    }
}
