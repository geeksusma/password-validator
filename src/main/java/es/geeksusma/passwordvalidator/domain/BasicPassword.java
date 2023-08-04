package es.geeksusma.passwordvalidator.domain;

class BasicPassword implements Password {

    private static final int MINIMUM_CHARS = 8;
    private static final char SYMBOL = '_';
    private final String password;

    private BasicPassword(String password) {
        this.password = password;
    }

    static BasicPassword of(String password) {
        return new BasicPassword(password);
    }

    @Override
    public boolean check() {
        return isNotEmpty() && hasMinimumOrMoreChars() && fulfillConditions();
    }

    private boolean fulfillConditions() {
        char[] chars = password.toCharArray();
        boolean hasANumber = false;
        boolean hasACapital = false;
        boolean hasALowerCase = false;
        boolean hasTheSymbol = false;
        for (char aChar : chars) {
            if (!hasANumber) {
                hasANumber = Character.isDigit(aChar);
            }
            if (!hasACapital) {
                hasACapital = Character.isUpperCase(aChar);
            }
            if (!hasALowerCase) {
                hasALowerCase = Character.isLowerCase(aChar);
            }
            if (!hasTheSymbol) {
                hasTheSymbol = aChar == SYMBOL;
            }
        }
        return hasANumber && hasACapital && hasALowerCase && hasTheSymbol;
    }

    private boolean isNotEmpty() {
        return password != null && !"".equals(password);
    }

    private boolean hasMinimumOrMoreChars() {
        return password.length() >= MINIMUM_CHARS;
    }
}
