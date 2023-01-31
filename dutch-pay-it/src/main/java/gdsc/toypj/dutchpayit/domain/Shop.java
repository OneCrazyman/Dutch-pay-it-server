package gdsc.toypj.dutchpayit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Shop {
    @Id @GeneratedValue
    @Column(name = "shop_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startT;

    private String shopName;

    public void addUser(User user){
        this.user =user;
        user.getShopList().add(this);
    }

    public static Shop createShop(User user, LocalDateTime startT, String shopName){
        Shop shop = new Shop();
        shop.addUser(user);
        shop.setStartT(startT);
        shop.setShopName(shopName);
        return shop;
    }
}
