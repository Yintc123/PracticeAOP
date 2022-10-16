package yin.practice.AOP;

// ArithmeticCaculator 的實作
public class ArithmeticCaculatorLoggingImpl implements ArithmeticCaculator {

	@Override
	public int add(int i, int j) {
		System.out.println("Yin -> The method add begins with [" + i + "," + j +"]");
		int result = i + j;
		System.out.println("Yin -> The method add ends with result " + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("Yin -> The method sub begins with [" + i + "," + j +"]");
		int result = i - j;
		System.out.println("Yin -> The method sub ends with result " + result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("Yin -> The method mul begins with [" + i + "," + j +"]");
		int result = i * j;
		System.out.println("Yin -> The method mul ends with result " + result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("Yin -> The method div begins with [" + i + "," + j +"]");
		int result = i / j;
		System.out.println("Yin -> The method div ends with result " + result);
		return result;
	}

}
