import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Test1 {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        User user = new User("HAlice", 28);
        session.save(user); // Persistent
        tx.commit();
        String hql = "from User"; //hql
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        for(User u: list){
            System.out.println(u);
        }
        HibernateUtil.closeSession();
    }

}
