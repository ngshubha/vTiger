package vTigerGenericUtilities;

import java.util.Random;

public class Java_Utility {
	

	/**
	 * This Method is used to avoid Duplicates
	 * @return
	 * @author Shubha
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}


}
