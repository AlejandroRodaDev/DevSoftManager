package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Hibernate {
    private static SessionFactory sessionFactory;
    private static Session session;

    /**
     * Constructor
     */
    public Hibernate() {

    }

    /**
     * Crea la factoría de sesiones.
     */
    public static void buildSessionFactory() {

        Configuration configuration = new Configuration();
        try {
            configuration.configure("hibernate.cfg.xml");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Crea la factoría de sesiones de usuarios.
     */
    public static void buildSessionFactoryUser() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernateUser.cfg.xml");

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Abre una nueva sesión
     */
    public static void openSession() throws HibernateException {

        session = sessionFactory.openSession();
    }

    /**
     * Devuelve la sesión actual
     * @return
     */
    public static Session getCurrentSession() {

        if ((session == null) || (!session.isOpen()))
            openSession();

        return session;
    }

    /**
     * Cierra la sesión.
     */
    public static void closeSessionFactory() {

        if (session != null)
            session.close();

        if (sessionFactory != null)
            sessionFactory.close();
    }
}
