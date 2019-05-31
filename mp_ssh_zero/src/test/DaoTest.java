import com.lanedy.pojo.TbRoleEntity;
import com.lanedy.pojo.TbUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by liyue
 * Time 2019-03-26 11:20
 */
public class DaoTest {
    @Test
    public void testHibernate(){
        Configuration configure = new Configuration().configure("/hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        TbUserEntity user = session.get(TbUserEntity.class, 1);
        System.out.println("user = " + user.getUserName());
        System.out.println("该用户拥有的角色数量：" + user.getRoles().size());
        TbRoleEntity role = user.getRoles().iterator().next();
        System.out.println("该角色拥有的权限数量：" + role.getPermissions().size());
        session.close();
        sessionFactory.close();
    }
}
