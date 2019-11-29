package thinking.in.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import thinking.in.spring.boot.config.WebConfiguration;

/**
 * Web 自动装配类
 */
@ConditionalOnWebApplication
@Configuration
@Import(WebConfiguration.class) //这是导入bean配置类
public class WebAutoConfiguration {
}
