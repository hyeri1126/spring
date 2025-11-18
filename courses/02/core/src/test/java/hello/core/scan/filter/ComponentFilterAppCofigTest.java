package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppCofigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA",BeanA.class);
        // beanA는 spring bean으로 등록
        Assertions.assertThat(beanA).isNotNull();
        // beanB는 spring bean으로 등록 x
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("beanB",BeanB.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyExcludeComponent.class)

    )
    static class ComponentFilterAppConfig {

    }
}
