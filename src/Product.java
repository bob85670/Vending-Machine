import java.util.ArrayList;

public class Product {

  private String name;
  private int price;
  private int quantity;

  public Product(String name, int price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
  
  public String toString() {
	  return Integer.toString(quantity);
  }
  

  /* You may add other properties and methods */
}