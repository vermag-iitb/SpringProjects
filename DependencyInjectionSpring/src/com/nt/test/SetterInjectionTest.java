/*
SEQUENTIAL STEPS OF FUNCTIONING WITH SPRING CONTAINER OF THIS PROJECT

STEP 1: Run the application (or main())
STEP 2: IOC container creation
STEP 3: Loads and verifies XML file content
STEP 4: Due to context:component-scan tag, it scan through all concerned packages to convert them to spring beans
STEP 5: Goes to classes and notices @Component or XML <bean> tag and make them spring beans
        (WMG - via annotation and LDT - via XML config)
STEP 6: Verifies if the spring beans are of singleton scope or more
STEP 7: IOC Container does pre-instantiation of Singleton scope spring beans
STEP 8: At the same time, notices for @Autowired annotation
        If found, then find for the dependent class's object reference in IOC container
STEP 9: Calls the @Autowired setter method, to assign dependent class object as defined in setter method
STEP 10: The objects created by IOC container, are stored in internal cache/buffer (temporary memory of IOC container)
         in a table (columns: bean ids and object references)
STEP 11: Comes back to main() and follows the sequence
STEP 12: All objects and IOC container are deleted
 */


package com.nt.test;
import com.nt.sbeans.WishMessageGenerator;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SetterInjectionTest
{
    public static void main(String[] args)
    {
        // Creating ApplicationContext container (IOC container)
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("com/nt/config/applicationContext.xml");
        // Getting target class object from IOC container's cache memory
        Object obj = ctx.getBean("wmg");
        // getBean() -> returns Object class's object
        // Downcasting the Object class's object to target class object
        WishMessageGenerator generator = (WishMessageGenerator) obj;
        System.out.println(generator.generateWishMessage("SpringGaurav"));
        ctx.close();
    }
}
