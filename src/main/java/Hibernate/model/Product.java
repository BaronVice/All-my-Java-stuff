package Hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "person_nickname", referencedColumnName = "nickname")
    private Person owner;

    @ManyToMany(mappedBy = "products")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Category> categories;

    public void addCategory(Category category){
        if (this.categories == null)
            this.categories = new ArrayList<>();

        this.categories.add(category);
        category.getProducts().add(this);
    }

    public void addCategory(List<Category> categories){
        if (this.categories == null)
            this.categories = new ArrayList<>();

        this.categories.addAll(categories);
        categories.forEach(category -> category.getProducts().add(this));
    }
}
