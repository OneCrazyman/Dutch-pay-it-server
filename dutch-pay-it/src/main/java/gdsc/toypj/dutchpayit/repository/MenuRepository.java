package gdsc.toypj.dutchpayit.repository;

import gdsc.toypj.dutchpayit.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final EntityManager em;

    //저장
    public void save(Menu menu){
        em.persist(menu);
    }

    //메뉴 찾기
    public Menu findOne(Long id){
        return em.find(Menu.class,id);
    }

    //삭제
    public void delete(Menu menu){
        em.remove(menu);
    }

    //모든 메뉴 찾기
    public List<Menu> findAll(){
        return em.createQuery("select r from Menu r", Menu.class)
                .getResultList();
    }

    public List<Menu> createdByMe(Long userId){
        return em.createQuery("select r from Menu r" +
                        " join fetch r.user m where m.id =: userId", Menu.class)
                .setParameter("userId",userId).getResultList();
    }


}
