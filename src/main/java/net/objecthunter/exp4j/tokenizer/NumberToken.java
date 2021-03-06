/*
* Copyright 2014 Frank Asseg
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.objecthunter.exp4j.tokenizer;

import java.math.BigDecimal;

import net.objecthunter.exp4j.TypeUtil;

/**
 * Represents a number in the expression
 */
public final class NumberToken extends Token {
    private final Number value;

    /**
     * Create a new instance
     * @param value the value of the number
     */
    public NumberToken(Number value) {
        super(TOKEN_NUMBER);
        this.value = value;
    }

    NumberToken(String value) {
        this(TypeUtil.parseConstant(value));
    }

    NumberToken(final char[] expression, final int offset, final int len) {
        this(String.valueOf(expression, offset, len));
    }

    /**
     * Get the value of the number
     * @return the value
     */
    public Number getValue() {
        return value;
    }

    public String toString() {
        return String.format("const %s", getValue());
    }

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof NumberToken) {
			NumberToken other = (NumberToken) obj;
			BigDecimal otherValue = new BigDecimal(other.getValue().toString());
			BigDecimal thisValue = new BigDecimal(value.toString());
			if(otherValue.compareTo(thisValue) == 0)
				result = true;
		}
		return result;
	}

}
