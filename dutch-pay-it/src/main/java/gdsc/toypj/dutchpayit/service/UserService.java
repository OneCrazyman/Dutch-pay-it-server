package gdsc.toypj.dutchpayit.service;

import gdsc.toypj.dutchpayit.domain.People;
import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.domain.User;
import gdsc.toypj.dutchpayit.dto.AddUserDto;
import gdsc.toypj.dutchpayit.repository.PeopleRepository;
import gdsc.toypj.dutchpayit.repository.MenuRepository;
import gdsc.toypj.dutchpayit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final PeopleRepository peopleRepository;

    // 사용자 생성
    @Transactional
    public User createUser(AddUserDto addUserDto){
        User user = User.addUser(addUserDto.getName());
        userRepository.save(user);

        return user;
    }

    //생성된 유저 전체 조회
    @Transactional
    public List<User> allUser(){
        List<User> user = userRepository.findAll();
        return user;
    }

    //최신 유저 조회
    @Transactional
    public User OneUser(){
        User user = userRepository.findOneUser();
        return user;
    }

    // 리스트 조회
    @Transactional
    public List<Menu> getMenuList(Long userId){
        return menuRepository.createdByMe(userId);
    }

    // 리스트 조회
    @Transactional
    public List<People> getPeopleList(Long userId){
        return peopleRepository.createdByMe(userId);
    }

    //삭제
    @Transactional
    public void deleteUser(Long userId){
        //사용자 엔티티 조회
        User findUser = userRepository.findOne(userId);

        //삭제
        userRepository.delete(findUser);
    }

//    @Transactional
//    public Integer getUserKey
}