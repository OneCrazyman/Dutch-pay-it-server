package gdsc.toypj.dutchpayit.Controller;

import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.dto.AllMenuDto;
import gdsc.toypj.dutchpayit.dto.CreateImageDto;
import gdsc.toypj.dutchpayit.dto.CreateMenuDto;
import gdsc.toypj.dutchpayit.dto.UpdateMenuDto;
import gdsc.toypj.dutchpayit.repository.MenuRepository;
import gdsc.toypj.dutchpayit.response.SuccessResponse;
import gdsc.toypj.dutchpayit.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;
    private final MenuRepository menuRepository;

    //form데이터로 request와 image를 받음
    //ML로 이미지 전송 (개발중)
    //분석 후 디비에 저장되면 리턴 (개발중)

    @PostMapping(value = "/send/image", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity sendImage(@RequestPart(value = "request") CreateImageDto request, @RequestPart(value = "image") MultipartFile imgFile,
                            HttpServletRequest httpServletRequest) throws IllegalStateException, IOException, InterruptedException {

        log.info("key_name:{}, shop:{}, image:{}", request.getKey_name(), request.getShop(), imgFile);

        //파이썬 서버가 켜져있어야 오류가 안뜸
        menuRepository.sendImageToPython(imgFile);

        List<Menu> menu = menuService.getImageMenu(request.getKey_name(),request.getShop());
        List<AllMenuDto> collect = menu.stream().map(r -> new AllMenuDto(r)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));
    }

    //메뉴 생성하기
    @PostMapping("/create/{UserId}")
    public ResponseEntity createMenu(@PathVariable Long UserId, @RequestBody CreateMenuDto createMenuDto){

        Long reserveId = menuService.createMenu(UserId,createMenuDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,reserveId));
    }

    //모든 메뉴 보여주기
    @GetMapping("/get/all")
    public ResponseEntity getAllMenu(){

        List<Menu> menu = menuService.allMenu();

        List<AllMenuDto> collect = menu.stream().map(r -> new AllMenuDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //메뉴 업데이트
    @PostMapping("/edit/{UserId}")
    public ResponseEntity updateMenu(@PathVariable Long UserId, @RequestBody UpdateMenuDto menuDto) {

        Long menu = menuService.updateMenu(UserId, menuDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, menu));
    }

    //삭제하기
    @DeleteMapping("/delete/{UserId}")
    public ResponseEntity deleteMenu(@PathVariable Long UserId){

        menuService.deleteMenu(UserId);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, null));
    }
}
