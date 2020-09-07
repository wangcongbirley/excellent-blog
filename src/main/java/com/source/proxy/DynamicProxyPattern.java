package com.source.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理代码实现
 * @author wangcongbirley
 * @date 2020-09-07
 */
class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
class JdkProxyFactory {
	
	private final SmsService smsService;
	
	public JdkProxyFactory(SmsService smsService) {
		this.smsService = smsService;
	}
	
    public Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}

public class DynamicProxyPattern {
	public static void main(String[] args) {
		JdkProxyFactory debugProxy = new JdkProxyFactory(new SmsServiceImpl());
		Object smsService =debugProxy.getProxy(SmsService.class);
		((SmsService) smsService).send("java");
	}
}
