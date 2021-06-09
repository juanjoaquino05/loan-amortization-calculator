/*
 * MIT License
 *
 * Copyright (c) 2021 Artyom Panfutov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package paqua.loan.amortization.dto;

import java.math.BigDecimal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import paqua.loan.amortization.utils.factory.LoanFactory;
import paqua.loan.amortization.utils.factory.ObjectMapperFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanTest {
    private static final ObjectMapper OBJECT_MAPPER = ObjectMapperFactory.create();

    @Test
    void shouldMatchSerializedAndDeserializedObjects() throws JsonProcessingException {
        Loan loan = LoanFactory.getDefaultWithEarlyPayments();

        String serialized = OBJECT_MAPPER.writeValueAsString(loan);
        Loan deserialized = OBJECT_MAPPER.readValue(serialized, Loan.class);

        assertEquals(deserialized, loan);
        assertEquals(deserialized.hashCode(), loan.hashCode());
    }

	@Test
	void shouldTakeDoubleValuesForLoan(){
		double amount = 500000.32;
		double rate = 4.56;

		Loan loan = Loan.builder()
				.amount(amount)
				.rate(rate)
				.term(10)
				.build();

		assertEquals(loan.getAmount(), BigDecimal.valueOf(amount));
		assertEquals(loan.getRate(), BigDecimal.valueOf(rate));
	}

}
