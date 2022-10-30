import com.test.entity.User;
import com.test.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/17 21:50
 * @Version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-*.xml" })
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void login(){
        User user = userService.login("110", "123");
        System.err.println(user);
    }
}
