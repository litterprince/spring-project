package spring.project;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.project.bean.Color;
import spring.project.bean.Person;
import spring.project.config.MainConfig;
import spring.project.config.PropertiesConfig;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器创建完成！");
        Color bean = applicationContext.getBean(Color.class);
        //System.out.println(bean);
        applicationContext.close();
    }

    @Test
    public void testProperties(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertiesConfig.class);
        System.out.println("容器创建完成！");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean.getName());
        System.out.println(bean.getSex());
        applicationContext.close();
    }
}
