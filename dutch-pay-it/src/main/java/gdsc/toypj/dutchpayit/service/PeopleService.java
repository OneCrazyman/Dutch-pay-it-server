package gdsc.toypj.dutchpayit.service;

import gdsc.toypj.dutchpayit.domain.People;
import gdsc.toypj.dutchpayit.domain.User;
import gdsc.toypj.dutchpayit.dto.CreatePeopleDto;
import gdsc.toypj.dutchpayit.dto.UpdatePeopleDto;
import gdsc.toypj.dutchpayit.repository.PeopleRepository;
import gdsc.toypj.dutchpayit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;

    private final UserRepository userRepository;

    @Transactional
    public Long createPeople(Long userID, CreatePeopleDto createPeopleDto){
        User user = userRepository.findOne(userID);
        People people = People.createPeople(user, createPeopleDto.getName(),
                createPeopleDto.getMenu(),createPeopleDto.getPrice(), createPeopleDto.getNumber());
        peopleRepository.save(people);
        return people.getId();
    }

    @Transactional
    public List<People> allPeople(){
        List<People> people = peopleRepository.findAll();
        return people;
    }

    @Transactional
    public Long updatePeople(Long peopleID, UpdatePeopleDto peopleDto){
        People people = peopleRepository.findOne(peopleID);
        people.setName(peopleDto.getName());
        people.setMenu(peopleDto.getMenu());
        people.setPrice(people.getPrice());
        people.setNumber(people.getNumber());

        return people.getId();
    }

    @Transactional
    public void deletePeople(Long peopleId){
        People findPeople = peopleRepository.findOne(peopleId);
        peopleRepository.delete(findPeople);
    }

}
