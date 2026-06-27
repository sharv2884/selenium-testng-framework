package testngpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {
	@BeforeSuite
	public void test1() {
		System.out.println("Before Suite");
	}
	@BeforeClass
	public void test2() {
		System.out.println("Before Class");
	}
	@BeforeTest
	public void test3() {
		System.out.println("Before test");
	}
	@BeforeMethod
	public void test4() {
		System.out.println("Before method");
	}
	@Test
	public void test5() {
		System.out.println("This is test method");
	}
	@AfterMethod
	public void test6() {
		System.out.println("After Method");
	}
	@AfterTest
	public void test7() {
		System.out.println("After Test");
	}
	@AfterClass
	public void test8() {
		System.out.println("After Class");
	}
	@AfterSuite
	public void test9() {
		System.out.println("After Suite");
	}
	

}
