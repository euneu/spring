package hello.core.order;

import hello.core.discount.DIscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DIscountPolicy {

    private int disountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * disountPercent / 100;
        } else {
            return 0;
        }
    }
}
