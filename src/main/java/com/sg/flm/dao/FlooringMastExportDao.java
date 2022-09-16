package com.sg.flm.dao;

import java.util.List;

public interface FlooringMastExportDao {
    void writeFile(List<String> myList) throws Exception;
}
