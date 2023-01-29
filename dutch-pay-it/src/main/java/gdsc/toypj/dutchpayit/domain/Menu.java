package gdsc.toypj.dutchpayit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Menu {
    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    private String menuName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_name")
    private User user;

    private float price;
    private int number;
    private String shop;

    public void addUser(User user){
        this.user=user;
        user.getMenuList().add(this);
    }

    public static Menu createMenu(User user, String menuName, float price, int number, String shop){

        Menu menu = new Menu();
        menu.addUser(user);
        menu.setMenuName(menuName);
        menu.setPrice(price);
        menu.setNumber(number);
        menu.setShop(shop);

        return menu;
    }
}