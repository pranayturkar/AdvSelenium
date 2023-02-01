package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void createContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		SoftAssert st = new SoftAssert();
		st.assertEquals(true,true);
		System.out.println("step3");
		System.out.println("step4");
		st.assertAll();
		
	}

	public void modify()
	{
		System.out.println("step5");
		System.out.println("step6");
		
	}
}
