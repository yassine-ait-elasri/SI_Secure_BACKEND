package SI_Secure.utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static String path="SI_Secure/utils/hibernate.cfg.xml";
    private static SessionFactory buildSessionFactory() {
    	System.out.print("here");
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().
                configure(path).build();

        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().
                build();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        SessionFactory sessionFactory = sessionFactoryBuilder.build();

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}