package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int id;

    public static void main(String[] args ) {
      HibernateUtil.getSessionFactory();
      Villages villages = new Villages("Bulolu","Jumabay",300,695);
        create(villages);
    for (Villages v:getAllVillages()){
        System.out.println(v);
    }
    update(16,"Ishenbay",789);
    deleted(17);
    }

    public static int create (Villages villages){
        Session session  = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(villages);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully created " + villages);
        return  villages.getId();
    }



    public static List<Villages> getAllVillages(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Villages>villages=session.createQuery("FROM Villages ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + villages.size() + " villages");
        return villages;
    }

    public static void update (int id ,String villagesMayor,int villagesPopulation){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
       try {
           session.beginTransaction();
           Villages villages = session.get(Villages.class,id);
           villages.setVillagesMayor(villagesMayor);
           villages.setVillagesPopulation(villagesPopulation);
           tx.commit();
           System.out.println("Succesfully updated " + villages);
       }catch (RuntimeException e){
           if (tx!=null)
               tx.rollback();
           System.out.println(e.getMessage());
       }finally {
           session.close();
       }



    }
    public static void deleted (int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Villages villages = session.get(Villages.class, id);
        session.delete(villages);
        session.getTransaction().commit();
        System.out.println("Succesfully deleted "+ villages);
        session.close();
        }


}
