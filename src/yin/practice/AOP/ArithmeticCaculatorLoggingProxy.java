package yin.practice.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCaculatorLoggingProxy {
	
	//要代理的對象
	private ArithmeticCaculator target;
	
	public ArithmeticCaculatorLoggingProxy(ArithmeticCaculator target) {
		
		this.target = target;
	}
	
	public ArithmeticCaculator getLoggingProxy() {

		ArithmeticCaculator proxy = null;
		
		// 代理對象由哪個類加載器負責加載
		ClassLoader loader = target.getClass().getClassLoader();
		// 代理對象的類型，及其中有哪些"方法"
		Class[] interfaces = new Class[] {ArithmeticCaculator.class};
		// invocation（n.）調用，當調用代理對象其中的方法時，該執行的代碼
		InvocationHandler handler = new InvocationHandler(){
			/**
			 * proxy：正在返回的那個代理對象，一般情況下，在invoke方法中都不使用該對象
			 * method：正在被調用的方法
			 * args：調用方法時傳入的參數
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				String methodName = method.getName();
				// 日誌 log
				System.out.println("The method " + methodName + " begins with [" + Arrays.asList(args) + "]");
				// 執行方法
				Object result = method.invoke(target, args);
				// 日誌 log
				System.out.println("The method " + methodName + " ends with " + result);
				return result;
			}
			
		};
 		proxy = (ArithmeticCaculator) Proxy.newProxyInstance(loader, interfaces, handler);
		
		return proxy;
	}
	
}
