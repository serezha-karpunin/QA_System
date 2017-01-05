package db.dao;

import db.entities.UsersEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsersDao extends GenericDaoHibernateImpl<UsersEntity, String> {

    public UsersDao() {
        super(UsersEntity.class);
    }
//    public void create(UsersEntity entity) {
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        s.beginTransaction();
//        s.save(entity);
//        s.getTransaction().commit();
//        s.close();
//    }

    public boolean isLoginExist(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM UsersEntity where login =:userLogin");
        query.setParameter("userLogin", login);
        boolean flag = query.list().size() != 0;
        s.close();
        return flag;
    }

    public boolean isEmailExist(String email) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM UsersEntity where email =:userEmail");
        query.setParameter("userEmail", email);
        boolean flag = query.list().size() != 0;
        s.close();
        return flag;
    }

    public boolean isUserCorrect(String login, String password) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query;
        if (login.contains("@")) {
            query = s.createQuery("FROM UsersEntity where email=:userEmail");
            query.setParameter("userEmail", login);
        } else {
            query = s.createQuery("FROM UsersEntity where login=:userLogin");
            query.setParameter("userLogin", login);
        }
        List<UsersEntity> list = query.list();
        password += list.get(0).getSalt();
        byte[] passHash;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        passHash = md.digest();

        if (list.size() != 0 && slowEquals(list.get(0).getPassword().getBytes(), passHash)) return true;
        else return false;
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        String a = "bbb";
//        UsersEntity usersEntity = new UsersEntity();
//        usersEntity.setLogin(a);
//        usersEntity.setEmail(a + "@ya.ru");
//        usersEntity.setPassword(a);
//        usersEntity.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
//        usersEntity.setLang(Locale.getDefault().toString());
//        usersDao.save(usersEntity);
        System.out.println(usersDao.getById(a).getEmail());
        usersDao.deleteById(a);
        System.out.println("HERE");
    }

}
