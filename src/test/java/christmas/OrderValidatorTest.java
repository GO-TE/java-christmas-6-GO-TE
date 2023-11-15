package christmas;

import christmas.util.validator.OrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class OrderValidatorTest {
    private OrderValidator orderValidator;

    @BeforeEach
    void setUp() {
        orderValidator = new OrderValidator();
    }

    @DisplayName("메뉴판에 없는 메뉴면 예외 처리 한다")
    @Test
    void createNonExistMenu() {
        String input = "오므라이스-1";
        assertThatThrownBy(() -> orderValidator.validateOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 주문 갯수가 1이상 정수가 아니라면 예외처리 한다.")
    @Test
    void createWrongNumberMenuCount() {
        String input = "티본스테이크-1.5";
        assertThatThrownBy(() -> orderValidator.validateOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문한다면 예외처리 한다.")
    @Test
    void createOrderOnlyDrink() {
        String input = "레드와인-1,샴페인-1";
        assertThatThrownBy(() -> orderValidator.validateOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 갯수가 20개 초과한다면 예외처리 한다.")
    @Test
    void createOverCountOrder() {
        String input = "크리스마스파스타-1225";
        assertThatThrownBy(() -> orderValidator.validateOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력 포멧이 아니라면 예외처리 한다.")
    @Test
    void createWrongRegexOreder() {
        String input = "티본스테이크 1개, 제로콜라 1개";
        assertThatThrownBy(() -> orderValidator.validateOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
