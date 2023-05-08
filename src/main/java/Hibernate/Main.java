package Hibernate;

import Hibernate.model.Category;
import Hibernate.model.Passport;
import Hibernate.model.Person;
import Hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> countries = new HashMap<>(
                Map.ofEntries(
                        Map.entry(0, "Murica"),
                        Map.entry(1, "DaWay"),
                        Map.entry(2, "Kurwa"),
                        Map.entry(3, "Raisa")
                )
        );

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Category.class)
        ;

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            List<Product> products = session.createQuery("from Product ").getResultList();
//            List<Category> categories = session.createQuery("from Category ").getResultList();

//            for (Product product : products){
//                System.out.println(product.getName());
//                if (product.getCategories().isEmpty()){
//                    System.out.println("This product doesn't belong to any category\n");
//                    continue;
//                }
//
//                System.out.printf("Categories: %s%n%n", product.getCategories().stream().map(Category::getName)
//                        .collect(Collectors.joining(", ")));
//            }

            session.getTransaction().commit();
        }
    }
}
