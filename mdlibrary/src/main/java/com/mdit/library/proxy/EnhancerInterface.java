package com.mdit.library.proxy;

public interface EnhancerInterface {
	
	public void setMethodInterceptor$Enhancer$(MethodInterceptor methodInterceptor);
	
	@SuppressWarnings("rawtypes")
	public Object executeSuperMethod$Enhancer$(String methodName, Class[] argsType, Object[] argsValue);

	/**
	 *
     */
	public void setCallBacksMethod$Enhancer$(MethodInterceptor[] methodInterceptor);

	/**
	 * filter
     */
	public void setCallBackFilterMethod$Enhancer$(CallbackFilter callbackFilter);

}
