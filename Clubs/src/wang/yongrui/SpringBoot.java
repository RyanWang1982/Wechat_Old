/**
 *
 */
package wang.yongrui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author I323560
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }

    // @Bean
    // public RepositoryRestConfigurer repositoryRestConfigurer() {
    // return new RepositoryRestConfigurerAdapter() {
    //
    // @Override
    // public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration) {
    // configuration.setBasePath("/api");
    //
    // // expose field "id" for all the beans with annotation @Entity
    // // refer to https://jira.spring.io/browse/DATAREST-366
    // ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
    // false);
    // provider.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
    // Set<BeanDefinition> components = provider
    // .findCandidateComponents(this.getClass().getPackage().getName());
    // List<Class<?>> classes = new ArrayList<>();
    // components.forEach(component -> {
    // try {
    // classes.add(Class.forName(component.getBeanClassName()));
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // });
    // configuration.exposeIdsFor(classes.toArray(new Class[classes.size()]));
    // }
    // };
    // }

}
