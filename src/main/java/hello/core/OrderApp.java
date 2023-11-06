package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        memberService.join(new Member(1L, "donggyu", Grade.VIP));
        Member member = memberService.findMember(1L);

        Order goodChalk = orderService.createOrder(1L, "goodchalk", 20000);

        int price = goodChalk.calculatePrice();

        System.out.println(price);
    }
}
