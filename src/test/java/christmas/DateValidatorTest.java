package christmas;

import christmas.util.validator.DateValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class DateValidatorTest {
    private DateValidator dateValidator;

    @BeforeEach
    void setUp() {
        dateValidator = new DateValidator();
    }

    @DisplayName("1~31사이 정수가 아니면 예외처리 한다")
    @Test
    void createOverDateInput() {
        String input = "30.9";
        assertThatThrownBy(() -> dateValidator.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

