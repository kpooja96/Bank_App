package com.capgemini.calculator.aspects;

import org.springframework.stereotype.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.*;

import  com.capgemini.calculator.service.*;

@Component
@Aspect
public class CalculatorValidAspect {
	
	@AfterThrowing("execution(* com.capgemini.calculator.service.Calculator.divide(..)),throwing="error")
	public void afterThrowingAdvice(JoinPoint jp, Throwable error)
	{
		System.out.println(Method Signature: " + jp.getSignature());
		System.out.println("Exception: "+error);
		
		
	}
	
	/*
	@Before("execution(* com.capgemini.calculator.service.CalculatorImp.divide(..))")
	public void divideValidation()
	{
		System.out.println("After execution..");
		
	}
	*/
}
			
		