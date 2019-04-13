package com.capgemini.calculator.aspects;
import  com.capgemini.calculator.service.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class CalculatorTest 	
{
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
		Calculator calculator=context.getBean(Calculator.class);
	
		calculator.add(10,20);
		calculator.divide(20.0,10.0);
	}
}

		