import com.lanedy.dao.IUserDao;
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
        System.out.println("输出测试");
    }
}
