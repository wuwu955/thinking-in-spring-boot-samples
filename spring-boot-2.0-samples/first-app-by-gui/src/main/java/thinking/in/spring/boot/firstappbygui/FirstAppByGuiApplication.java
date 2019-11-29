package thinking.in.spring.boot.firstappbygui;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thinking.in.spring.boot.config.WebConfiguration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Configuration
//@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = "thinking.in.spring.boot.config") //这个是扫描包
public class FirstAppByGuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppByGuiApplication.class, args);
		//这里的启动类变成其他带有@SpringBootApplication 注解的类 他扫描的是他的包下的配置
		//这个类其他注解一概没有
//		SpringApplication.run(WebConfiguration.class, args);
	}

//    /**
//     * {@link ApplicationRunner#} 方法在
//     * Spring Boot 应用启动后回调
//     *
//     * @param context WebServerApplicationContext
//     * @return ApplicationRunner Bean
//     *
//     * UndertowWebServer 这里证明创建了但是日志 打印的是UndertowServletWebServer
//     * 的bug(UndertowWebServer 类的日志申明)
//     * 后续采用 web 服务器初始化监听来解决 see WebConfiguration
//     */
//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context) {
//        return args -> {
//            System.out.println("当前 WebServer 实现类为："
//                    + context.getWebServer().getClass().getName());
//        };
//    }
}
