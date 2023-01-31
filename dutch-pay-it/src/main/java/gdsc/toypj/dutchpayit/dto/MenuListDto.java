package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.Menu;
import lombok.Data;

@Data
public class MenuListDto {
    private Long menuId;
    private String menuName;
    private float price;
    private int number;
    private String shop;

    public MenuListDto(Menu menu){
        menuId = menu.getId();
        menuName = menu.getMenuName();
        price = menu.getPrice();
        number = menu.getNumber();
        shop = menu.getShop();
    }
}
