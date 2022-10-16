// reference；https://www.youtube.com/watch?v=8zt_HftX-4g

package yin.practice.AOP;

public class Main {

	public static void main(String[] args) {
		
//		ArithmeticCaculator arith = new ArithmeticCaculatorLoggingImpl();
		ArithmeticCaculator target = new ArithmeticCaculatorImpl();
		ArithmeticCaculator proxy = new ArithmeticCaculatorLoggingProxy(target).getLoggingProxy();
		
		int result = proxy.add(8, 2);
		System.out.println("-->" + result);
		
		result = proxy.sub(8, 2);
		System.out.println("-->" + result);
		
		result = proxy.mul(8, 2);
		System.out.println("-->" + result);
		
		result = proxy.div(8, 2);
		System.out.println("-->" + result);
	}

}
