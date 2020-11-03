package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInputTest() {
        assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INPUT_VALUE_IS_NULL_OR_EMPTY);
    }

    @Test
    @DisplayName("입력 값이 공백 경우")
    public void blankInputTest() {
        assertThatThrownBy(() -> calculator.calculate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INPUT_VALUE_IS_NULL_OR_EMPTY);
    }

    @ParameterizedTest
    @DisplayName("올바른 사칙 연산 기호가 아닌 경우")
    @ValueSource(strings = {"2 + 3 * 4 # 2"})
    public void isNotValidOperator(String input) {
        assertThatThrownBy(() ->
            calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.IS_NOT_VALID_OPERATOR);
    }

    @ParameterizedTest
    @DisplayName("덧셈")
    @CsvSource(value = {"1 + 2 : 3", "4 + 2 : 6"}, delimiter = ':')
    public void add(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈")
    @CsvSource(value = {"5 - 3 : 2", "7 - 2 : 5"}, delimiter = ':')
    public void subtract(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈")
    @CsvSource(value = {"4 * 2 : 8", "3 * 3 : 9"}, delimiter = ':')
    public void multiple(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈")
    @CsvSource(value = {"16 / 2 : 8", "6 / 3 : 2"}, delimiter = ':')
    public void divide(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("0으로 나눈 경우")
    @ValueSource(strings = {"15 / 0"})
    public void divideWithZero(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(Constants.DIVIDE_BY_ZERO);
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기")
    @CsvSource(value = {"4 * 3 + 6 / 9 - 1 : 1"}, delimiter = ':')
    public void calculate(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }



}