package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	/*@Test
	public void createContact() {
		System.out.println("step1");
		System.out.println("Step2");
		//HardAssert
		Assert.assertEquals(false,true);
		//					(actu,expe)
		System.out.println("Step3");
		System.out.println("step4");
	}
	@Test
	public void modifyContact() {
		System.out.println("step5");
		System.out.println("step6");
	}*/
	
	@Test
	public void create()
	{
		String expName="shobha";
		String actuName="ShobhaRani";
		Assert.assertEquals(expName,actuName);
		
	}
}
