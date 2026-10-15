package org.cuatrovientos.product;

import java.math.BigDecimal;

public class Product { 
    // Declarar las variables
    private final long id;
    private final String name;
    private final BigDecimal price;

    public Product(long id, String name, BigDecimal price) { 
        // Inicializar las variables
        this.id = id;
        this.name = name;
        this.price = price;
    } 
  
    public long getId() { 
        return id; 
    } 
  
    public String getName() { 
        return name; 
    } 
  
    public BigDecimal getPrice() { 
        return price; 
    } 
}

