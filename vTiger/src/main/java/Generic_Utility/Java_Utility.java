package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method is used for Avoiding Duplicate
	 * @return
	 * @author Ultra
	 */
	public int getRandomNum() {
		Random r = new Random();
		int ranNum=r.nextInt(1000);
		return ranNum;
		
	}

}
