package thinking.in.spring.boot.firstappbygui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//解决 mvn 打包问题
@SpringBootTest(classes = FirstAppByGuiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FirstAppByGuiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
