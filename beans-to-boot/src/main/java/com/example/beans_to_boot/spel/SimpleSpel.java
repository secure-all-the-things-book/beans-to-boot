package com.example.beans_to_boot.spel;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;

@Configuration
class SimpleSpel {

	SimpleSpel() {
		// <.>
		var spelExpressionParser = new SpelExpressionParser();

		// <.>
		simple(spelExpressionParser);
	}

	private void simple(ExpressionParser expressionParser) {
		var expression = expressionParser.parseExpression("1 + 2");
		var evaluatedValue = expression.getValue(Integer.class).intValue();
		Assert.state(3 == evaluatedValue, "the values should match");
	}

}
