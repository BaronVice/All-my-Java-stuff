package Hibernate.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Product> products;

//    @OneToOne(mappedBy = "owner")
//    private Passport passport;
}
