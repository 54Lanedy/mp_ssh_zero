import com.lanedy.dao.IUserDao;
import com.lanedy.pojo.TbUserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liyue
 * Time 2019-03-26 15:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class SpringTest {

    @Resource
    private IUserDao userDao;

    @Test
    public void testSpring(){
        TbUserEntity user = new TbUserEntity();
        user.setUserName("zhangsan");
        user.setUserPassword("123456");
        TbUserEntity userforLogin = userDao.findUserForLogin(user);
        Assert.assertEquals("zhangsan",userforLogin.getUserName());
    }
}
