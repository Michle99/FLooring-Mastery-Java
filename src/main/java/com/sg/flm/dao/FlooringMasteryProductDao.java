
package com.sg.flm.dao;

import com.sg.flm.dto.Product;

import java.util.List;

public interface FlooringMasteryProductDao {
    
 List<Product> loadProductList() throws Exception; 
    
}
