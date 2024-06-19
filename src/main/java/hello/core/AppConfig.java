package hello.core;

import hello.core.discount.DIscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberSeriveImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.order.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberSeriveImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), dIscountPolicy());
    }

    @Bean
    public DIscountPolicy dIscountPolicy(){
        return new RateDiscountPolicy();
    }
}
