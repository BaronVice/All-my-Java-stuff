package Hibernate;

import Hibernate.model.Person;
import Hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            session.createQuery("update Person set age=123 where nickname like '%d%'").executeUpdate();
//            List<Person> people = session.createQuery("from Person").getResultList();
//            people.forEach(System.out::println);

            Person person = session.get(Person.class, "Abobus");
            System.out.println(person.getNickname());
            List<Product> products = person.getProducts();
            for (Product product : products)
                System.out.printf("%s - %s%n", product.getId(), product.getName());

            session.getTransaction().commit();
        }
    }
}
