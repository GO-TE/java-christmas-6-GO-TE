package christmas.util;

import christmas.util.message.ErrorMessage;

public class DateValidator {
    private final String DATE_REGEX = "^\\d+$";
    private final String MENU_REGEX = "^([가-힣]+-\\d+,?)+$";

    private int validateDateRegex(String input) {
        if (!input.matches(DATE_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_ERROR.getMessage());
        }
        return Integer.parseInt(input);
    }

    public void validateDate(String input) {
        int date = validateDateRegex(input);
        if (date > 31 || date < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE_ERROR.getMessage());
        }
    }

}
