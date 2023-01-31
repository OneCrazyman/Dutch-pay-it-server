package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.Menu;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllMenuDto {
    private Long menuId;
    private String MenuName;
    private String shop;
    private int number;
    private float price;
    private LocalDateTime startT;

    public AllMenuDto(Menu menu){
        menuId = menu.getId();
        MenuName = menu.getMenuName();
        shop = menu.getShop();
        number = menu.getNumber();
        price = menu.getPrice();
        startT = menu.getStartT();
    }
}