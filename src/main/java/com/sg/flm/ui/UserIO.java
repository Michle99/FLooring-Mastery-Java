package com.sg.flm.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UserIO {

    void print(String msg);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);
    
    String readOptionalState(String prompt);

    BigDecimal readBigDecimal(String prompt);
    BigDecimal readOptionalBigDecimal(String prompt);

    BigDecimal readBigDecimal(String prompt, int scale);

    BigDecimal readBigDecimal(String prompt, int scale, BigDecimal min);

    LocalDate readLocalDate(String prompt);
    
    String readState(String prompt);
    
    String readProduct(String prompt);
    
    String readOptionalProduct(String prompt);

    String readString(String prompt);

}
