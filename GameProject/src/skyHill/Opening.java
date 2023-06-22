package skyHill;

import java.util.concurrent.TimeUnit;

public class Opening {
	String[] openingScript;
	String[] openingScript2;
	String[] openingScript3;
	String[] openingScript4;
	String[] openingScript5;
	String[] openingScript6;

	public Opening() {
		openingScript = "나는 사업상 며칠 머무르려고 스위트룸을 예약했어.".split("");
		openingScript2 = "아무생각 없이 그저 적막함을 채우기 위해 라디오를 켰고,".split("");
		openingScript3 = "라디오에서는\"...ㅅ..ㅐ화학무ㄱ..대피소...위험ㅎ...\"".split("");
		openingScript4 = "나는 불길한 예감에 경찰, 119.. 할 수 있는 모든 시도를 해봤어.".split("");
		openingScript5 = "하지만 밖에선 알 수 없는 으르렁 거리는 소리와 비명소리 뿐이었어.".split("");
		openingScript6 = "그리고...".split("");
	}

	public void showOpening() {
		// script1
		System.out.println();
		for (int i = 0; i < openingScript.length; i++) {
			System.out.print(openingScript[i]);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// script2
		for (int i = 0; i < openingScript2.length; i++) {
			System.out.print(openingScript2[i]);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// script3
		for (int i = 0; i < openingScript3.length; i++) {
			System.out.print(openingScript3[i]);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// script4
		for (int i = 0; i < openingScript4.length; i++) {
			System.out.print(openingScript4[i]);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// script5
		for (int i = 0; i < openingScript5.length; i++) {
			System.out.print(openingScript5[i]);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// script6
		for (int i = 0; i < openingScript6.length; i++) {
			System.out.print(openingScript6[i]);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
