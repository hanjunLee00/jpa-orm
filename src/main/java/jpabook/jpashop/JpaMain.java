package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "100"));
//
//            //값 타입 컬렉션들을 persist 하지 않아도 자동으로 저장됨
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "100"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "100"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("============== START ==============");
//
//            Member findMember = em.find(Member.class, member.getId());
//            Address a = findMember.getHomeAddress();
//
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            //equals hashcode 오버라이딩 된 메소드로 제거됨
//            findMember.getAddressHistory().remove(new Address("old1", "street", "100"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "100"));

            Member member = new Member();
            member.setName("kim");
            em.persist(member);

            List<Member> result = em.createQuery(
                    "select m From Member m where m.name like '%kim%'", Member.class
            ).getResultList();

            for(Member m : result) {
                System.out.println("m = " + m);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

//        int a = 10;
//        int b = 10;
//        System.out.println("a==b = " + (a == b));
//
//        Address address1 = new Address("city", "street", "100");
//        Address address2 = new Address("city", "street", "100");
//        System.out.println("(address1 == address2 = " + (address1 == address2));
//        //equals, hasCode 오버라이드하여 동등성 비교 (equivalence 비교)
//        System.out.println("address1 == address2: " + (address1.equals(address2)));
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));
    }

    private static void printMember(Member member) {
        System.out.println("member.getName() = " + member.getName());
    }

    private static void printMemberAndTeam(Member member) {
        String name = member.getName();
        System.out.println("username = " + name);

        Team team = member.getTeam();
        System.out.println("team.getName() = " + team.getName());
    }
}
