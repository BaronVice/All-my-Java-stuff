package Hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Passport")
@Data
@NoArgsConstructor
public class Passport implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "passport_nickname", referencedColumnName = "nickname")
    private Person owner;

    @Column(name = "country")
    private String country;

    public Passport (Person person, String country){
        owner = person;
        this.country = country;
        person.setPassport(this);
    }
}
