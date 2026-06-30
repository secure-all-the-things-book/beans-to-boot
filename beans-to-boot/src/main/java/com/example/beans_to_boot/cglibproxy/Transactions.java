package com.example.beans_to_boot.cglibproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.transaction.support.TransactionTemplate;

import java.lang.reflect.Method;

class Transactions {

	static Object createProxy(TransactionTemplate tt, Object target) {
		var pfb = new ProxyFactoryBean();
		pfb.setProxyTargetClass(true);
		pfb.setTarget(target);
		for (var i : target.getClass().getInterfaces())
			pfb.addInterface(i);
		pfb.addAdvice((MethodInterceptor) invocation -> doInTx(tt, target, invocation.getMethod(),
				invocation.getArguments()));
		return pfb.getObject();
	}

	private static Object doInTx(TransactionTemplate tt, Object target, Method method, Object[] args) {

		return tt.execute(_ -> {
			try {
				try {
					IO.println("before tx");
					return method.invoke(target, args);
				} //
				finally {
					IO.println("after tx");
				}
			} //
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}

}
