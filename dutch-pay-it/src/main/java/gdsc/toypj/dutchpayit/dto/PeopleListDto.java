package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.People;
import lombok.Data;

@Data
public class PeopleListDto {
    private Long peopleId;
    private String name;
    private String menu;
    private String shop;
    private int price;
    private int number;

    public void AllPeopleDto(People people){
        peopleId = people.getId();
        name = people.getName();
        menu = people.getMenu();
        shop = people.getShop();
        price = people.getPrice();
        number = people.getNumber();
    }
}