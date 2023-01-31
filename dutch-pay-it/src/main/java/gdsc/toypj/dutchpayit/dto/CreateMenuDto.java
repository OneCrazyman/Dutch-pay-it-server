package gdsc.toypj.dutchpayit.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateMenuDto {
    private String menuName;
    private float price;
    private int number;
    private String shop;
    private LocalDateTime startT;
}
