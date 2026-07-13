package com.example.beans_to_boot.spel;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.Assert;

import java.util.List;

@Configuration
class ContextSpel {

	private final List<Order> orders = List.of(new Order("sku1"), new Order("sku2"));

	ContextSpel() {
		var spelExpressionParser = new SpelExpressionParser();
		context(spelExpressionParser);
	}

	private void context(ExpressionParser expressionParser) {
		var context = new StandardEvaluationContext();
		// <.>
		context.setVariable("orders", orders);
		// <.>
		Assert.state(
				expressionParser.parseExpression("#orders.size()").getValue(context, Integer.class).intValue() == 2,
				"the values should match");
	}

}
