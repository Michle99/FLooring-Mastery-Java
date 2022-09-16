package com.sg.flm.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static java.math.BigDecimal.ROUND_UP;

public class UserIOConsoleImpl implements UserIO {

    private final Scanner input = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        boolean valid = false;
        int result = 0;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = Integer.parseInt(value);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number.\n", value);
            }
        } while (!valid);
        return result;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean valid = false;
        int result = 0;

        do {
            result = readInt(prompt);
            if (result >= min && result <= max) {
                valid = true;
            } else {
                System.out.printf("The value must be between %d and %d.\n", min, max);
            }
        } while (!valid);

        return result;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        boolean isValid = false;
        BigDecimal result = BigDecimal.ZERO;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = new BigDecimal(value);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number. \n", ex);
            }
        } while (!isValid);
        return result;
    }
    @Override
    public BigDecimal readBigDecimal(String prompt, int scale) {
        boolean valid = false;
        BigDecimal result = null;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = new BigDecimal(value).setScale(scale, ROUND_UP);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number.\n", value);
            }
        } while (!valid);
        return result;
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt, int scale, BigDecimal min) {
        boolean valid = false;
        BigDecimal result = null;
        do {
            result = readBigDecimal(prompt, scale);
            if (result.compareTo(min) >= 0) {
                valid = true;
            } else {
                String minString = String.valueOf(min);
                System.out.printf("The value must be greater than %s.\n", minString);
            }
        } while (!valid);

        return result;
    }

    @Override
    public BigDecimal readOptionalBigDecimal(String prompt) {
        boolean isValid = false;
        BigDecimal result = BigDecimal.ZERO;
        do {
            String value = null;
            try {
                value = readString(prompt);
                if (!value.equals("")) {
                    result = new BigDecimal(value);
                    isValid = true;
                } else {
                    result = BigDecimal.ZERO;
                    isValid = true;
                }
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number. \n");
            }
        } while (!isValid);
        return result;
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        boolean isValid = false;
        LocalDate result = LocalDate.MAX;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = LocalDate.parse(value, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a Date. \n", ex);
            }
        } while (!isValid);
        return result;
    }

    @Override
    public String readState(String prompt) {
        boolean valid = false;
        String result = "";
        do {
            String value = null;

            value = readString(prompt);
            if (value.equals("OH") || value.equals("PA") || value.equals("MI") || value.equals("IN")) {
                result = value;
                valid = true;
            } else {
                System.out.printf("You Must Select One Of The Options Provided!  ");
            }

        } while (!valid);
        return result;
    }
    
    @Override
    public String readOptionalState(String prompt) {
        boolean valid = false;
        String result = "";
        do {
            String value = null;

            value = readString(prompt);
            if (value.equals("OH") || value.equals("PA") || value.equals("MI") || value.equals("IN")) {
                result = value;
                valid = true;
            } else if(value.equals("")) {
                result = value;
                valid = true;
            } else {
                System.out.printf("You Must Select One Of The Options Provided!  ");
            }

        } while (!valid);
        return result;
    }

    @Override
    public String readProduct(String prompt) {
        boolean valid = false;
        String result = "";
        do {
            String value = null;

            value = readString(prompt);
            if (value.equals("Carpet") || value.equals("Laminate") || value.equals("Tile") || value.equals("Wood")) {
                result = value;
                valid = true;
            } else {
                System.out.printf("You Must Select One Of The Options Provided!  ");
            }

        } while (!valid);
        return result;
    }
    
     @Override
    public String readOptionalProduct(String prompt) {
        boolean valid = false;
        String result = "";
        do {
            String value = null;

            value = readString(prompt);
            if (value.equals("Carpet") || value.equals("Laminate") || value.equals("Tile") || value.equals("Wood")) {
                result = value;
                valid = true;
            } else if(value.equals("")) {
                result = value;
                valid = true;
            } else {
                System.out.printf("You Must Select One Of The Options Provided!  ");
            }

        } while (!valid);
        return result;
    }
}
