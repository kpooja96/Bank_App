package com.capgemini.calculator.service;

import org.springframework.stereotype.*;

@Component
public class CalculatorImp implements Calculator {
	public void add(Integer a,Integer b) {
	System.out.println(a + b);
	}
	
	public void divide(Double num1,Double num2)
	{
	System.out.println( num1/num2);
	}
}

