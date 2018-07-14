package SpringExample.aop;

//监控对象，不需要特殊处理
public class Logging {
	/**
	 * This is the method which I would like to execute
	 * before a selected method execution.
	 */
	public void beforeAdvice(){
		System.out.println("Going to setup student profile.");
	}
	/**
	 * This is the method which I would like to execute
	 * after a selected method execution.
	 */
	public void afterAdvice(){
		System.out.println("Student profile has been setup.");
	}
	/**
	 * This is the method which I would like to execute
	 * when any method returns.
	 */
	public void afterReturningAdvice(Object retVal){
		// 这里能获取到监控对象的返回值
		System.out.println("Returning:" + retVal.toString() );
	}
	/**
	 * This is the method which I would like to execute
	 * if there is an exception raised.
	 */
	public void AfterThrowingAdvice(IllegalArgumentException ex){
		// 这里能获取到监控对象抛出的异常
		System.out.println("There has been an exception: " + ex.toString());
	}
}
