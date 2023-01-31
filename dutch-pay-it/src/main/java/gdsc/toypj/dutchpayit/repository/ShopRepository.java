package gdsc.toypj.dutchpayit.repository;

import gdsc.toypj.dutchpayit.domain.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShopRepository {
    private final EntityManager em;

    //저장
    public void save(Shop shop){
        em.persist(shop);
    }

    //메뉴 찾기
    public Shop findOne(Long id){
        return em.find(Shop.class,id);
    }

    //삭제
    public void delete(Shop shop){
        em.remove(shop);
    }

    //모든 메뉴 찾기
    public List<Shop> findAll(){
        return em.createQuery("select r from Shop r", Shop.class)
                .getResultList();
    }


    public List<Shop> createdByMe(Long userId){
        return em.createQuery("select r from Shop r" +
                        " join fetch r.user m where m.id =: userId", Shop.class)
                .setParameter("userId",userId).getResultList();
    }
}
