package thinking.in.spring.boot.samples.auto.configuration.listener;

import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.Set;

/**
 * 自定义 {@link AutoConfigurationImportListener} 实现
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0 see page 315 自动配置导入监听 @AutoConfigureBefore 尽量用name来指定
 */
public class DefaultAutoConfigurationImportListener implements AutoConfigurationImportListener {

    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
        // 获取当前 ClassLoader
        ClassLoader classLoader = event.getClass().getClassLoader();
        // 候选的自动装配类名单
        List<String> candidates =
                SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, classLoader);
        // 实际的自动装配类名单
        List<String> configurations = event.getCandidateConfigurations();
        // 排除的自动装配类名单
        Set<String> exclusions = event.getExclusions();
        // 输出各自数量
        System.out.printf("自动装配类名单 - 候选数量：%d，实际数量：%d，排除数量：%s\n",
                candidates.size(), configurations.size(), exclusions.size());
        // 输出实际和排除的自动装配类名单
        System.out.println("实际的自动装配类名单：");
        event.getCandidateConfigurations().forEach(System.out::println);
        System.out.println("排除的自动装配类名单：");
        event.getExclusions().forEach(System.out::println);
    }
}
