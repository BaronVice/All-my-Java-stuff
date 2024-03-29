package Hibernate.model;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Person")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable {
    @Id
    @Column(name = "nickname")
    @NonNull
    private String nickname;

    @Column(name = "age")
    @NonNull
    private int age;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.PERSIST)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
              org.hibernate.annotations.CascadeType.REFRESH})
    private Passport passport;

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
}
