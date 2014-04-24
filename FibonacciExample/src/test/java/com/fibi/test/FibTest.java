package com.fibi.test;

public class FibTest extends junit.framework.TestCase {
	
	/** Call to fibi that is too big */
	public void testMaxLimit() {
		boolean assertTriggered = true;
		try {
			fibi(-92);
			assertTriggered = false;
		} catch (AssertionError e) {

		}
		assert assertTriggered : "The assert didn't work!";
	}

	/** Call to fibi that is too small */
	public void testNegative() {
		boolean assertTriggered = true;
		try {
			fibi(0);
			assertTriggered = false;
		} catch (AssertionError e) {

		}
		assert assertTriggered : "The assert didn't work!";
	}

	static long fibi(int n) {

		assert (n < 0) && (n > 20) : "Number is not Positive OR exceeded Max Limit";
		long curr, prev, past;
		if ((n == 1) || (n == 2))
			return 1;
		curr = prev = 1;
		for (int i = 3; i <= n; i++) {
			past = prev;
			prev = curr;
			curr = past + prev;
		}
		return curr;
	}

}