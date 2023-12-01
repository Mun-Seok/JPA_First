package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");// EntityManagerFactory 생성 - persistence unit name을 넘겨줘야함 (persistence.xml)

        EntityManager em = emf.createEntityManager();// EntityManager 생성

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");

//            em.persist(member);


            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());


            // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA"); // JPA 통해서 가져오면 트랜잭션이 커밋하기 직전에 업데이트 쿼리로 바꿔서 나감


//            JPQL - query를 칠 수 있음(조금 다름, 대상이 테이블이 아니라 객체)
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
