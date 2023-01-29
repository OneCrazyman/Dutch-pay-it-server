package gdsc.toypj.dutchpayit.service;

import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.domain.User;
import gdsc.toypj.dutchpayit.dto.CreateMenuDto;
import gdsc.toypj.dutchpayit.dto.UpdateMenuDto;
import gdsc.toypj.dutchpayit.repository.MenuRepository;
import gdsc.toypj.dutchpayit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    //메뉴 생성
    @Transactional
    public Long createMenu(Long userId, CreateMenuDto createMenuDto){
        User user = userRepository.findOne(userId);
        Menu menu = Menu.createMenu(user, createMenuDto.getMenuName(), createMenuDto.getPrice(),
                createMenuDto.getNumber(), createMenuDto.getShop());
        menuRepository.save(menu);
        return menu.getId();
    }

    // 모든 메뉴 리스트 조회
    @Transactional
    public List<Menu> allMenu(){
        List<Menu> menu = menuRepository.findAll();
        return menu;
    }

    // 업데이트
    @Transactional
    public Long updateMenu(Long menuId, UpdateMenuDto menuDto){

        Menu menu = menuRepository.findOne(menuId);

        menu.setMenuName(menuDto.getMenuName());
        menu.setShop(menuDto.getShop());
        menu.setPrice(menuDto.getPrice());
        menu.setNumber(menuDto.getNumber());

        return menu.getId();
    }

    //삭제
    @Transactional
    public void deleteMenu(Long menuId){
        //메뉴 엔티티 조회
        Menu findMenu = menuRepository.findOne(menuId);

        //삭제
        menuRepository.delete(findMenu);
    }
}
