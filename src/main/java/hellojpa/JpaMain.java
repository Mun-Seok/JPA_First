package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
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

/*
//            JPQL - query를 칠 수 있음(조금 다름, 대상이 테이블이 아니라 객체)
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
*/
/*
            // 비영속- 객체를 생성하기만 함, 저장하지 X
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
*/
/*
            // 영속 - 엔티티 매니저 안 영속성 컨텍스트로 관리가 됨, DB에 저장안됨 트랜잭션 커밋할 때 저장됨
            System.out.println("===BEFORE===");
            em.persist(member); // 1차 캐시에 저장
//            em.detach(member); // 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
            System.out.println("===AFTER===");
*/

/*
           Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember = " + findMember.getId()); // 1차 캐시에서 조회 → 조회 query 안나감
            System.out.println("findMember = " + findMember.getName());
            */

            // 객체를 삭제한 상태(삭제)
//            em.remove(member);

/*
           // 영속
            Member findMember1 = em.find(Member.class, 101L); // DB에 있던 값 조회 → 1차 캐시에 저장
            Member findMember2 = em.find(Member.class, 101L); // 1차 캐시에 저장되어 쿼리 실행 안되고 반환

            System.out.println("result = " + (findMember1 == findMember2)); // jpa가 영속 엔티티의 동일성 보장해야함
*/
/*
            Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L,"B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("=========="); // 쓰기 지연 SQL에 쌓아둬 DB에 커밋 안됨
 */
/*
            // 수정
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ"); // 변경해도 persist 안해도 됨/자바 컬렉션처럼 다룸

            System.out.println("======");
*/

/*
            // 플러시
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush(); // 플러시 직접 호출

            System.out.println("========");
*/
/*            // 준영속 상태

            Member member = em.find(Member.class,150L); // 영속 상태로 올림
            member.setName("AAAAA");*/

//            em.detach(member); // 준영속 상태가 됨, JPA에서 관리 안함 → UPDATE 쿼리 안나감

//            em.clear(); // 영속성 컨텍스트 다 초기화함
//            Member member2 = em.find(Member.class, 150L); // 초기화되서 새로 조회 쿼리

//            System.out.println("=======");

           /*
            Member member = new Member();
            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);
            */

       /*     Member member = new Member();
            member.setId("ID_A");
            member.setUsername("C");*/

//            em.persist(member);


  /*
            Movie movie = new Movie();
            movie.setDirector("aaa");
            movie.setActor("bbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " +findMovie);
            */

            Member member = new Member();
            member.setUsername("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);


            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
