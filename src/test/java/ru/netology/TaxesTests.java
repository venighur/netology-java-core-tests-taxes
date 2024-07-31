package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaxesTests {
    @Test
    public void testTaxEarnings() {
        int earnings = 50, expected = 3;

        int result = Taxes.taxEarnings(earnings);

        Assertions.assertEquals(expected, result);
    }

    @MethodSource
    @ParameterizedTest
    public void testTaxEarningsMinusSpendings(int earings, int spendings, int expected) {
        int result = Taxes.taxEarningsMinusSpendings(earings, spendings);

        Assertions.assertEquals(expected, result);
    }

    public Stream<Arguments> testTaxEarningsMinusSpendings() {
        return Stream.of(
                Arguments.of(100, 50, 7),
                Arguments.of(50, 100, 0),
                Arguments.of(100, 100, 0)
        );
    }
}
