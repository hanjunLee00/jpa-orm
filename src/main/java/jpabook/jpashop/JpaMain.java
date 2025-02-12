package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
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
