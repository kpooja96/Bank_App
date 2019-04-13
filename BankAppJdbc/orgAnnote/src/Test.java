package com.capgemini.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.capgemini.spring.model.*;

public class OrganizationAppTest 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    	Organization orgn = (Organization)context.getBean(Organization.class);
	System.out.println(orgn);
    }
}