package gdsc.toypj.dutchpayit.repository;

import gdsc.toypj.dutchpayit.domain.People;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class PeopleRepository {
    private final EntityManager em;

    //저장
    public void save(People people){
        em.persist(people);
    }

    //people_id로 찾기
    public People findOne(Long id){
        return em.find(People.class,id);
    }

    //메뉴 찾기
    public People findOne(String menu){
        return em.find(People.class,menu);
    }

    //삭제
    public void delete(People people){
        em.remove(people);
    }

    //모든 테이블 확인
    public List<People> findAll(){
        return em.createQuery("select r from People r", People.class)
                .getResultList();
    }


    public List<People> createdByMe(Long userId){
        return em.createQuery("select r from People r" +
                        " join fetch r.user m where m.id =: userId", People.class)
                .setParameter("userId",userId).getResultList();
    }

}