package hello.core.Discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @param member
     * @param price
     * @return 할인 금액 리턴
     */
    int discount(Member member, int price);
}
