package gdsc.toypj.dutchpayit.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class CreateShopDto {
    private LocalDateTime startT;
    private String shopName;
}
