package Hibernate;

import Hibernate.model.Person;
import Hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
//                .addAnnotatedClass(Passport.class)
        ;

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = session.get(Person.class, "Abobus");
            session.delete(person);
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.save(new Passport("Abobus", "Uganda"));
//            session.save(new Passport("Man", "Murica"));
////            session.createQuery("update Person set age=123 where nickname like '%d%'").executeUpdate();
////            List<Person> people = session.createQuery("from Person").getResultList();
////            people.forEach(System.out::println);
//            Person person = session.get(Person.class, "Abobus");
//            System.out.println(person.getNickname());
//            List<Product> products = person.getProducts();
//            for (Product product : products)
//                System.out.printf("%s - %s%n", product.getId(), product.getName());
            for (Product product : person.getProducts()){
                System.out.println(product.getName());
            }
            session.getTransaction().commit();
        }
    }
}
