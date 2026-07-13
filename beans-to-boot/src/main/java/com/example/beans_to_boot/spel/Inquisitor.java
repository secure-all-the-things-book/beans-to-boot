package com.example.beans_to_boot.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
class Inquisitor {

	Inquisitor(@Value("#{ theAnswerToLifeTheUniverseAndEverything.answer() } ") int answer) {
		// <.>
		Assert.state(answer == 42, "the values should match");
	}

}

@Component
class TheAnswerToLifeTheUniverseAndEverything {

	public int answer() {
		return 42;
	}

}