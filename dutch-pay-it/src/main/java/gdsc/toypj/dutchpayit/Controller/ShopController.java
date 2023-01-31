package gdsc.toypj.dutchpayit.Controller;

import gdsc.toypj.dutchpayit.domain.Shop;
import gdsc.toypj.dutchpayit.dto.*;
import gdsc.toypj.dutchpayit.response.SuccessResponse;
import gdsc.toypj.dutchpayit.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    //식당 생성하기
    @PostMapping("/create/{UserId}")
    public ResponseEntity createShop(@PathVariable Long UserId, @RequestBody CreateShopDto createShopDto){

        Long reserveId = shopService.createShop(UserId,createShopDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,reserveId));
    }

    //모든 식당 보여주기
    @GetMapping("/get/all")
    public ResponseEntity getAllShop(){

        List<Shop> shop = shopService.allShop();

        List<AllShopDto> collect = shop.stream().map(r -> new AllShopDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));
    }

    //식당 업데이트
    @PostMapping("/edit/{UserId}")
    public ResponseEntity updateShop(@PathVariable Long UserId, @RequestBody UpdateShopDto shopDto) {

        Long shop = shopService.updateShop(UserId, shopDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, shop));
    }

    //삭제하기
    @DeleteMapping("/delete/{UserId}")
    public ResponseEntity deleteShop(@PathVariable Long UserId){

        shopService.deleteShop(UserId);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, null));
    }
}
