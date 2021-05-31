package models.utilsclass;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

public class CustomGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("prefix");
    }

    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String query = String.format("select %s from %s",
                sharedSessionContractImplementor.getEntityPersister(o.getClass().getName(), o).getIdentifierPropertyName(), o.getClass().getSimpleName());
        Stream<String> ids = sharedSessionContractImplementor.createQuery(query).stream();
        long max = ids.map(s -> s.replace(prefix + "-", "")).mapToLong(Long::parseLong).max().orElse(0);
        return prefix + "-" + (max + 1);
    }
}
