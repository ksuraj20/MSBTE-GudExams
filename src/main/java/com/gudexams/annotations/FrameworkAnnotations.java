package com.gudexams.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.gudexams.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations
	{
		
		public String[] author() default {"Suraj_K"};
		public CategoryType[] category();
		
		
	}
