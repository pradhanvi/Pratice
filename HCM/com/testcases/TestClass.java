package com.testcases;

import com.commons.TestBase;

import hcm.pagefactory.ManagePerson;

public class TestClass extends TestBase {
	public static void main(String [] args)  {
		try {
			System.out.println("Unique data "+cmnLib.randomNumber("SCM"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
