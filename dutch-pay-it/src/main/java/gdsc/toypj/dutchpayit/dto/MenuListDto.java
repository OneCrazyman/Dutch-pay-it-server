package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.Menu;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MenuListDto {
    private Long menuId;
    private String menuName;
    private float price;
    private int number;
    private String shop;
    private LocalDateTime startT;

    public MenuListDto(Menu menu){
        menuId = menu.getId();
        menuName = menu.getMenuName();
        price = menu.getPrice();
        number = menu.getNumber();
        shop = menu.getShop();
        startT = menu.getStartT();
    }
}
