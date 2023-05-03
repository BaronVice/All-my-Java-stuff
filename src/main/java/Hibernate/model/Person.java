package Hibernate.model;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Person")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @Column(name = "nickname")
    @NonNull
    private String nickname;

    @Column(name = "age")
    @NonNull
    private int age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
              org.hibernate.annotations.CascadeType.REFRESH})
    private List<Product> products;

    public void addProduct(Product product){
        if (this.products == null)
            this.products = new ArrayList<>();

        products.add(product);
        product.setOwner(this);
    }

//    @OneToOne(mappedBy = "owner")
//    private Passport passport;
}
