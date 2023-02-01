package TestNG;

import org.testng.annotations.Test;

public class Test1 {
	

	@Test(priority=1)
	
	public void create() { 
		
		System.out.println("m1 running");
	}
	@Test(priority=3)
	public void modify() {
		System.out.println("m2 runing");
	}
	
	@Test(priority=2)
	public void delete() {
		System.out.println("m3 running");
	}

}
