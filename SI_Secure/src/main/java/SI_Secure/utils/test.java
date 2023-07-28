package SI_Secure.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import SI_Secure.dao.entity.Si_Version;

public class test {

    public static void setup() {
        SessionFactory sessionFactory = new Configuration()
                .configure("SI_Secure/utils/hibernate.cfg.xml") // Provide the path to your Hibernate configuration file
                .addAnnotatedClass(Si_Version.class) // Map the Si_Version class
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // Begin the transaction
            session.beginTransaction();
            Si_Version si = new Si_Version();
            si.setEol("BIBA");
            session.save(si);
            // Your code to work with the database goes here
            // For example, you can save or query the Si_Version entity

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the SessionFactory when you are done using it
            sessionFactory.close();
        }
    }

    public static Si_Version getOnlyOne() {
        SessionFactory sessionFactory = new Configuration()
                .configure("SI_Secure/utils/hibernate.cfg.xml") // Provide the path to your Hibernate configuration file
                .addAnnotatedClass(Si_Version.class) // Map the Si_Version class
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Si_Version";
            Si_Version result = session.createQuery(hql, Si_Version.class)
                    .setMaxResults(1)
                    .uniqueResult();

            // Process the first record
            if (result != null) {
                // Do something with the first record
                System.out.println(result.toString());
                return result;
            } else {
                // Handle the case when the table is empty
                System.out.println("ELSE\n\n");
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // Close the SessionFactory when you are done using it
            sessionFactory.close();
        }
    }

    public static Date convertStringToDate(String dateString, String formatPattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
        return sdf.parse(dateString);
    }

    public static void main(String[] args) {
        // Call the setup() method to insert a record into the database
        setup();

        // Call the getOnlyOne() method to fetch a record from the database
        Si_Version s = getOnlyOne();

        // Create a new Si_Version object and set its attributes
        Si_Version siv = new Si_Version();
        siv.setEquipement("ordinateur");
        siv.setModel("windows 10");
        siv.setOs("windows 10");

        // Get the current date
        Date currentDate = Calendar.getInstance().getTime();

        try {
            Date date = convertStringToDate(s.getEol(), "dd-MM-yyyy");
            System.out.print(!date.before(currentDate)+"validation");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
