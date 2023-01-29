package gdsc.toypj.dutchpayit.repository;

import gdsc.toypj.dutchpayit.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    //저장
    public void save(User user){
        em.persist(user);
    }

    //사용자 찾기
    public User findOne(Long id){
        return em.find(User.class,id);
    }

    //삭제
    public void delete(User user){
        em.remove(user);
    }

    //모든 사용자 찾기
    public List<User> findAll(){
        return em.createQuery("select r from User r", User.class)
                .getResultList();
    }

}
