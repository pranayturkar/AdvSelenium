package TestNG;

import org.testng.annotations.Test;

public class Test3Invocationount {
	@Test(invocationCount = 2)
	public void create() {
		int[] arr= {1,2,3};
		System.out.println("arr[5]");
	}
	@Test(dependsOnMethods="create")
	public void modify() {
		System.out.println("Modified");
	}
	@Test(dependsOnMethods="modify")
	public void delete() {
		System.out.println("Deleted");
	}

}
