package com.pac.model.utilsclass;

import org.apache.tomcat.jni.Address;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pac.model.Autohouse;
import com.pac.model.Car;
import com.pac.model.User;
import com.pac.model.Contract;
import com.pac.model.Driver;
import com.pac.model.Model;
import com.pac.model.Price;
import com.pac.model.Promotion;

import lombok.NoArgsConstructor;

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
        configuration.addAnnotatedClass(Driver.class);
        configuration.addAnnotatedClass(Model.class);
        configuration.addAnnotatedClass(Price.class);
        configuration.addAnnotatedClass(Promotion.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

}
