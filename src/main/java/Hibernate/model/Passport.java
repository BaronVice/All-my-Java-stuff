package Hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Passport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    @Id
    @JoinColumn(name = "passport_nickname", referencedColumnName = "nickname")
    private String owner;

    @Column(name = "country")
    private String country;
}
