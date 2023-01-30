package gdsc.toypj.dutchpayit.service;

import gdsc.toypj.dutchpayit.domain.Shop;
import gdsc.toypj.dutchpayit.domain.User;
import gdsc.toypj.dutchpayit.dto.CreateShopDto;
import gdsc.toypj.dutchpayit.dto.UpdateShopDto;
import gdsc.toypj.dutchpayit.repository.ShopRepository;
import gdsc.toypj.dutchpayit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    //메뉴 생성
    @Transactional
    public Long createShop(Long userId, CreateShopDto createShopDto){
        User user = userRepository.findOne(userId);
        Shop shop = Shop.createShop(user, createShopDto.getStartT(), createShopDto.getShopName());
        shopRepository.save(shop);
        return shop.getId();
    }

    // 모든 메뉴 리스트 조회
    @Transactional
    public List<Shop> allShop(){
        List<Shop> shop = shopRepository.findAll();
        return shop;
    }

    // 업데이트
    @Transactional
    public Long updateShop(Long shopId, UpdateShopDto shopDto){

        Shop shop = shopRepository.findOne(shopId);

        shop.setShopName(shopDto.getShopName());
        shop.setStartT(shopDto.getStartT());
        return shop.getId();
    }

    //삭제
    @Transactional
    public void deleteShop(Long shopId){
        //메뉴 엔티티 조회
        Shop findShop = shopRepository.findOne(shopId);

        //삭제
        shopRepository.delete(findShop);
    }
}
