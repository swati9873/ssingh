package genericUtility;

import java.util.Random;

public class JavaLibrary {
	public static int getrandomNumber() {
	
//Random ranDom = new Random();
//	int ranDomNum =  ranDom.nextInt(range);
//	String ranDomNumber = Integer.toString(ranDomNum);
//	return ranDomNumber;
	
	Random ranDom = new Random();
	int ranDomNum=ranDom.nextInt(1000);
	return ranDomNum;
	
}

	
}
