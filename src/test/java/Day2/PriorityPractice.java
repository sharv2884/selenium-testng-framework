package Day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityPractice {
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
		System.out.println("Before Test");
	}
	@BeforeMethod
	public void test4() {
		System.out.println("Before Method");
	}
	@Test (priority=2, groups="smoke")
	public void test5() {
		System.out.println("This is test method with priority 2");
		System.out.println("this belongs to smoke testing");
	}
	@Test (priority=1, groups="regression")
	public void test10() {
		System.out.println("This is test method with priority 1");
		System.out.println("this belongs to regression testing");

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
