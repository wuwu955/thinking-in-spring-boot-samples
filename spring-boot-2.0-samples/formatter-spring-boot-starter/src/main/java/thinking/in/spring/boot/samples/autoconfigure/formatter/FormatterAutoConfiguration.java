package thinking.in.spring.boot.samples.autoconfigure.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Formatter 自动装配
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0 see page 369
 */
@Configuration
@ConditionalOnProperty(prefix = "formatter", name = "enabled", havingValue = "true",
        matchIfMissing = true) // 当属性配置不存在时，同样视作匹配
@ConditionalOnResource(resources = "META-INF/spring.factories")
@ConditionalOnNotWebApplication
@ConditionalOnExpression("${formatter.enabled:true}")
public class FormatterAutoConfiguration {

    /**
     * 构建 {@link DefaultFormatter} Bean
     * 当ObjectMapper 不存在时就是这个 bean
     * @return {@link DefaultFormatter}
     */
    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }

    /**
     * JSON 格式 {@link Formatter} Bean
     * 当ObjectMapper类 存在 但是ObjectMapper bean 不存在时就是这个 JsonFormatter 默认构造 bean
     * 去掉ConditionalOnMissingBean
     * @return {@link JsonFormatter}
     */
    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter jsonFormatter() {
        return new JsonFormatter();
    }

    /**
     * 当ObjectMapper类 存在 但是ObjectMapper bean 存在 构造 objectMapperFormatter bean
     * @param objectMapper
     * @return
     */
    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public Formatter objectMapperFormatter(ObjectMapper objectMapper) {
        return new JsonFormatter(objectMapper);
    }


}
