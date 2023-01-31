package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.People;
import lombok.Data;

@Data
public class AllPeopleDto {
    private Long peopleId;
    private String name;
    private String menu;
    private int price;
    private int number;

    public AllPeopleDto(People people){
        peopleId = people.getId();
        name = people.getName();
        menu = people.getMenu();
        price = people.getPrice();
        number = people.getNumber();
    }
}