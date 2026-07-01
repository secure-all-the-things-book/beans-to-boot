package com.example.beans_to_boot.jdkproxy;

import org.springframework.transaction.support.TransactionTemplate;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Transactions {

	static Object createProxy(TransactionTemplate tt, Object target) {
		var classLoader = target.getClass().getClassLoader();
		var interfaces = target.getClass().getInterfaces();
		// <.>
		return Proxy.newProxyInstance(classLoader, interfaces, (_, method, args) -> doInTx(tt, target, method, args));
	}

	// <.>
	private static Object doInTx(TransactionTemplate tt,
			// <.>
			Object target,
			// <.>
			Method method,
			// <.>
			Object[] args) {
		return tt.execute(_ -> {
			try {
				try {
					IO.println("before tx");
					// <.>
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
