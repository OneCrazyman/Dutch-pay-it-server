package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.Shop;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ShopListDto {
    private Long shopId;
    private LocalDateTime startT;
    private String shopName;

    public ShopListDto(Shop shop){
        shopId = shop.getId();
        startT = shop.getStartT();
        shopName = shop.getShopName();
    }
}