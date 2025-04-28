package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * XML
     * Annotations
     * @param args
     */
    public static void main(String[] args) {
        try( var context =
                     new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            //by type
            /*
            MyBean b1 = context.getBean(MyBean.class);
            MyBean b2 = context.getBean(MyBean.class);
            MyBean b3 = context.getBean(MyBean.class);
            */

            //by name
            MyBean b1 = context.getBean("A", MyBean.class);
            MyBean b2 = context.getBean("myBean2", MyBean.class);
            MyBean b3 = context.getBean("A", MyBean.class);

            // due to default - singleton it will be same bean
            System.out.println(b1.getText());
            System.out.println(b2.getText());
            System.out.println(b3.getText());

        }
    }


}
