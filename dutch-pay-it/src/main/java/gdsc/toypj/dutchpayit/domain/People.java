package gdsc.toypj.dutchpayit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "people_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_name")
    private User user;

    private String name;
    private String menu;
    private String shop;
    private float price; //float로 수정
    private int number;

    public void addUser(User user){
        this.user=user;
        user.getPeopleList().add(this);
    }

    public static People createPeople(User user, String name, String menu, String shop, int price, int number){

        People people = new People();
        people.addUser(user);
        people.setName(name);
        people.setMenu(menu);
        people.setShop(shop);
        people.setPrice(price);
        people.setNumber(number);

        return people;
    }

}