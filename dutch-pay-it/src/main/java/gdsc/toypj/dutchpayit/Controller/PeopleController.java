package gdsc.toypj.dutchpayit.Controller;

import gdsc.toypj.dutchpayit.domain.People;
import gdsc.toypj.dutchpayit.dto.*;
import gdsc.toypj.dutchpayit.response.SuccessResponse;
import gdsc.toypj.dutchpayit.service.PeopleService;
import lombok.RequiredArgsConstructor;
import gdsc.toypj.dutchpayit.dto.UpdatePeopleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gdsc.toypj.dutchpayit.dto.AllPeopleDto;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    //참여인원 생성하기
    @PostMapping("/create/{UserId}")
    public ResponseEntity createMenu(@PathVariable Long UserId, @RequestBody CreatePeopleDto createPeopleDto){

        Long reserveId = peopleService.createPeople(UserId,createPeopleDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,reserveId));
    }

    //모든 항목 보여주기
    @GetMapping("/get/all")
    public ResponseEntity getAllPeople(){

        List<People> people = peopleService.allPeople();

        List<AllPeopleDto> collect = people.stream().map(r -> new AllPeopleDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //메뉴명으로 먹은사람 모두 출력
    @GetMapping("/get/all/{Menu}")
    public ResponseEntity findByMenu(@PathVariable String Menu){

        List<People> people = peopleService.findByMenu(Menu);

        List<AllPeopleDto> collect = people.stream().map(r -> new AllPeopleDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //메뉴명 AND 가게명으로 먹은사람 모두 출력
    @GetMapping("/get/all/{Shop}/{Menu}")
    public ResponseEntity findByShopANDMenu(@PathVariable String Shop,@PathVariable String Menu){

        List<People> people = peopleService.findByShopANDMenu(Shop, Menu);

        List<AllPeopleDto> collect = people.stream().map(r -> new AllPeopleDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));
    }

    //항목 업데이트
    @PostMapping("/edit/{UserId}")
    public ResponseEntity updatePeople(@PathVariable Long UserId, @RequestBody UpdatePeopleDto peopleDto) {

        Long people = peopleService.updatePeople(UserId, peopleDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, people));
    }

    //삭제하기
    @DeleteMapping("/delete/{UserId}")
    public ResponseEntity deletePeople(@PathVariable Long UserId){

        peopleService.deletePeople(UserId);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, null));
    }

}