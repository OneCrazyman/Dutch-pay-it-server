package gdsc.toypj.dutchpayit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_name")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<People> peopleList = new ArrayList<>();

    public static User addUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }
}
