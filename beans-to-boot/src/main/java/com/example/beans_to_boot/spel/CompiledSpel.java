package com.example.beans_to_boot.spel;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;

import java.util.List;

@Configuration
class CompiledSpel {

	private final List<Order> orders = List.of(new Order("sku1"), new Order("sku2"));

	CompiledSpel() {
		// <.>
		var configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
				Thread.currentThread().getContextClassLoader());
		var spelExpressionParser = new SpelExpressionParser(configuration);
		compiled(spelExpressionParser);
	}

	private void compiled(ExpressionParser expressionParser) {
		Assert.state(expressionParser.parseExpression("size()").getValue(orders, Integer.class).intValue() == 2,
				"the values should match");
	}

}
