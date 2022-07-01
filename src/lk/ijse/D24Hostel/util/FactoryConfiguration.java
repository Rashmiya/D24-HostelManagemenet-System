package lk.ijse.D24Hostel.util;

import lk.ijse.D24Hostel.entity.Reservation;
import lk.ijse.D24Hostel.entity.Room;
import lk.ijse.D24Hostel.entity.Student;
import lk.ijse.D24Hostel.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;


    private FactoryConfiguration() {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();

        Metadata meta = new MetadataSources(ssr)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(User.class)
                .getMetadataBuilder().build();

        sessionFactory =meta.getSessionFactoryBuilder().build();

    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }

}


