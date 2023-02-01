package gdsc.toypj.dutchpayit.dto;

import gdsc.toypj.dutchpayit.domain.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllUserDto {
    private Long key_name;
    private String name;

    public AllUserDto(User user){
        key_name = user.getId();
        name = user.getName();
    }
}