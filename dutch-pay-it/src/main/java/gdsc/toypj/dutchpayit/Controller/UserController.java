package gdsc.toypj.dutchpayit.Controller;

import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.domain.User;
import gdsc.toypj.dutchpayit.dto.AddUserDto;
import gdsc.toypj.dutchpayit.dto.AllMenuDto;
import gdsc.toypj.dutchpayit.dto.AllUserDto;
import gdsc.toypj.dutchpayit.dto.MenuListDto;
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

    // 사용자 생성 // 성공시 생성된 유저키를 반환
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody AddUserDto addUserDto){
        User user = userService.createUser(addUserDto);
        

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,user));

    }

    //최근 유저키 가져오기
    @GetMapping("/get/one")
    public ResponseEntity getOneUser(){

        User user = userService.OneUser();

//        collect = user.stream().map(r -> new AllUserDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,user));

    }

    //모든 유저 보여주기
    @GetMapping("/get/all")
    public ResponseEntity getAllUser(){

        List<User> user = userService.allUser();

        List<AllUserDto> collect = user.stream().map(r -> new AllUserDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //내가 먹은 메뉴 보여주기
    @GetMapping("/get/mymenu/{UserId}")
    public ResponseEntity getMenuList(@PathVariable Long UserId){

        List<Menu> menu = userService.getMenuList(UserId);

        List<MenuListDto> collect = menu.stream().map(r -> new MenuListDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //회원 탈퇴
    @DeleteMapping("/delete/{UserId}")
    public ResponseEntity deleteUser(@PathVariable Long UserId) {
        userService.deleteUser(UserId);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }


}
