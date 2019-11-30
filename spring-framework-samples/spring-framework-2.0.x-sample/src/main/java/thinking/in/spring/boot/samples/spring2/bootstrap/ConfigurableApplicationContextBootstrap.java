package thinking.in.spring.boot.samples.spring2.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.boot.samples.spring2.bean.Student;

/**
 * 可配置的 Spring {@link ApplicationContext} 引导类
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class ConfigurableApplicationContextBootstrap {

    static {
        // 调整系统属性 "env"，实现 "name" bean 的定义切换
        // envValue 可能来自于 "-Denv=dev" 命令行启动参数 java -jar -Denv=prod xx.jar
        // 参数当不存在时，使用 "prod" 作为默认值
        String envValue = System.getProperty("env");
        if (envValue == null || "".equals(envValue)) {
            envValue = "dev";
        }
        System.setProperty("env", envValue);
    }

    public static void main(String[] args) {

        try { // 定义 XML ApplicationContext
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configurable-context.xml");
            // "student" bean 对象
            Student value = (Student) context.getBean("student");
            // "name" bean 内容输出
            System.out.println("Bean 'student' 的内容为：" + value);
            // 启动
            context.start();
            //保持启动
            while (context.isActive()) {
                Thread.sleep(20);
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("退出");
        }
    }
}
