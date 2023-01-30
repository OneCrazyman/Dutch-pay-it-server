package gdsc.toypj.dutchpayit.Controller;

import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.domain.Shop;
import gdsc.toypj.dutchpayit.dto.AddUserDto;
import gdsc.toypj.dutchpayit.dto.MenuListDto;
import gdsc.toypj.dutchpayit.dto.ShopListDto;
import gdsc.toypj.dutchpayit.response.SuccessResponse;
import gdsc.toypj.dutchpayit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //회원가입
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody AddUserDto addUserDto){
        userService.createUser(addUserDto);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }

    //내가 먹은 메뉴 보여주기
    @GetMapping("/get/mymenu/{UserId}")
    public ResponseEntity getMenuList(@PathVariable Long UserId){

        List<Menu> menu = userService.getMenuList(UserId);

        List<MenuListDto> collect = menu.stream().map(r -> new MenuListDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    @GetMapping("/get/myshop/{UserId}")
    public ResponseEntity getShopList(@PathVariable Long UserId){

        List<Shop> shop = userService.getShopList(UserId);

        List<ShopListDto> collect = shop.stream().map(r -> new ShopListDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //회원 탈퇴
    @DeleteMapping("/delete/{UserId}")
    public ResponseEntity deleteUser(@PathVariable Long UserId) {
        userService.deleteUser(UserId);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }


}
