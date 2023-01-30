package gdsc.toypj.dutchpayit.service;

import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.domain.Shop;
import gdsc.toypj.dutchpayit.domain.User;
import gdsc.toypj.dutchpayit.dto.AddUserDto;
import gdsc.toypj.dutchpayit.repository.MenuRepository;
import gdsc.toypj.dutchpayit.repository.ShopRepository;
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
    private final ShopRepository shopRepository;

    // 사용자 생성
    @Transactional
    public Long createUser(AddUserDto addUserDto){
        User user = User.addUser(addUserDto.getName());
        userRepository.save(user);
        return user.getId();
    }


    // 리스트 조회
    @Transactional
    public List<Menu> getMenuList(Long userId){
        return menuRepository.createdByMe(userId);
    }

    @Transactional
    public List<Shop> getShopList(Long userId){
        return shopRepository.createdByMe(userId);
    }

    //삭제
    @Transactional
    public void deleteUser(Long userId){
        //사용자 엔티티 조회
        User findUser = userRepository.findOne(userId);

        //삭제
        userRepository.delete(findUser);
    }
}
