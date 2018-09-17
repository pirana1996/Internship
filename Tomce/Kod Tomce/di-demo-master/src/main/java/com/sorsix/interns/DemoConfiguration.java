package com.sorsix.interns;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * The Spring Framework is an application framework and inversion of
 * control container for the Java platform. The framework's core features
 * can be used by any Java application, but there are extensions for
 * building web applications on top of the Java EE (Enterprise Edition) platform.
 *
 * Bean is simple class which is annotated just to denote to Spring that it should
 * be inserted in the object graph in container/context.
 *
 * @ComponentScan means that all components in this package should be translated
 * in beans.
 *
 * @Component (and @Service and @Repository) are used to auto-detect and auto-configure
 * beans using classpath scanning. There's an implicit one-to-one mapping between the
 * annotated class and the bean (i.e. one bean per class).
 * As long as these classes are in under our base package or Spring is aware
 * of another package to scan, a new bean will be created for each of these classes.
 *
 * @Bean is used to explicitly declare a single bean, rather than letting Spring do it
 * automatically as above. It decouples the declaration of the bean from the class definition,
 * and lets you create and configure beans exactly how you choose.
 * With @Bean you aren’t placing this annotation at the class level.
 * If you tried to do that you would get an invalid type error.
 * Typically, @Bean methods are declared within @Configuration classes.
 *
 * So if we use default constructor of we have a constructor which dependencies
 * are beans then we don't have to work with configuration
 */

@Configuration
@ComponentScan("com.sorsix.interns")
public class DemoConfiguration {

    /**
     * Default bean scope is singleton.
     */
    @Bean
    public Engine engine() {
        System.out.println("creating engine");
        return new OtoEngine(100);
    }

    /**
     * The prototype scope. If the scope is set to prototype, the Spring IoC container
     * creates a new bean instance of the object every time a request for that specific
     * bean is made. As a rule, use the prototype scope for all state-full beans and the
     * singleton scope for stateless beans.
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Transmission transmission() {
        System.out.println("creating transmission");
        return new Transmission("auto");
    }
}
