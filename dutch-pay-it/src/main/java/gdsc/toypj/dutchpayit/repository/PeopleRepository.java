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

    //삭제
    public void delete(People people){
        em.remove(people);
    }

    //메뉴명으로 먹은사람 모두 출력 -> 메뉴명 AND 가게명으로 코드 수정 필요!!!!
    public List<People> findByMenu(String menu) {
        return em.createQuery("select m from People m where m.menu = :menu", People.class)
                .setParameter("menu", menu)
                .getResultList();
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