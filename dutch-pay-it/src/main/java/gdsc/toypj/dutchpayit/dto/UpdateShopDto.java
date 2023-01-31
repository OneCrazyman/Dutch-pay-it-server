package gdsc.toypj.dutchpayit.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class UpdateShopDto {
    private LocalDateTime startT;
    private String shopName;
}
