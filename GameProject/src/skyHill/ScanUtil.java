package skyHill;

import java.util.Scanner;

public class ScanUtil {
	private static Scanner sc = new Scanner(System.in); //static이기 때문에 객체를만들지 않아도 사용 가능
//  이하 동문
	public static String nextLine() {
		return sc.nextLine();
	}

	public static int nextInt() { 
		return Integer.parseInt(sc.nextLine());
	}

}
