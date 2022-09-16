package com.sg.flm.dao;


import com.sg.flm.dto.Tax;
import java.util.List;

 public interface FlooringMasteryTaxDao {

    List<Tax> loadTaxRates() throws Exception;
}
