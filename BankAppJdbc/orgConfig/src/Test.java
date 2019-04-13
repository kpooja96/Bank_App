package com.capgemini.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.capgemini.spring.service.*;
import com.capgemini.spring.config.*;

public class Test 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    	Organization orgn = (Organization)context.getBean("organization");
 
	System.out.println(orgn);

    }
}