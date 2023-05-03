package Hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "person_nickname", referencedColumnName = "nickname")
    private Person owner;
}
