package com.pac.model.utilsclass;

import com.pac.model.*;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
@Scope("singleton")
public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Autohouse.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Contract.class);
        configuration.addAnnotatedClass(Price.class);
        configuration.addAnnotatedClass(Promotion.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

}
