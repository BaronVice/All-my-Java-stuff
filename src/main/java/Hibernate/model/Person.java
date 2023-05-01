package Hibernate.model;


import lombok.*;

import javax.persistence.*;

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
}
