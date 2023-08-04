package es.geeksusma.passwordvalidator.domain;

class BasicPassword implements Password {

    private static final int MINIMUM_CHARS = 8;
    private final String password;

    private BasicPassword(String password) {
        this.password = password;
    }

    static BasicPassword of(String password) {
        return new BasicPassword(password);
    }

    @Override
    public boolean check() {
        return isNotEmpty() && hasMinimumOrMoreChars() && hasACapitalLetter() && hasALowerCase() && hasANumber() && hasASymbol('_');
    }

    private boolean hasASymbol(char symbol) {
        return containsASymbol(password.toCharArray(), symbol);
    }

    private boolean containsASymbol(char[] chars, char symbol) {
        for (char aChar : chars) {
            if (aChar == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean hasANumber() {
        return containsANumber(password.toCharArray());
    }

    private boolean containsANumber(char[] chars) {
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasALowerCase() {
        return containsALowerCase(password.toCharArray());
    }

    private static boolean containsALowerCase(char[] chars) {
        for (char aChar : chars) {
            if (Character.isLowerCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasACapitalLetter() {
        return containsAnUpperCase(password.toCharArray());
    }

    private static boolean containsAnUpperCase(char[] chars) {
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotEmpty() {
        return password != null && !"".equals(password);
    }

    private boolean hasMinimumOrMoreChars() {
        return password.length() >= MINIMUM_CHARS;
    }
}
