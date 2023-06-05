import java.util.ArrayList;
import java.util.*;

public class VendingMachine {
  // ArrayList of Integers represents inserted coins in Coin Slot
  private ArrayList<Integer> insertedCoins;
	
  // ArrayList of Product represents inventories of products
  private ArrayList<Product> products;
  
  private ArrayList<String> rejectedCoins;
  
  private ArrayList<Integer> productQuan;
  
  private ArrayList<String> realRejectedCoins;
  

  public VendingMachine() {
    insertedCoins = new ArrayList<Integer>();
    products = new ArrayList<Product>();
    rejectedCoins = new ArrayList<String>();
    productQuan = new ArrayList<Integer>();
    realRejectedCoins = new ArrayList<String>();
  }
  
  public ArrayList<String> realRejectCoins(){
      Collections.sort(insertedCoins);
      for (int i = 0; i<insertedCoins.size(); i++){
          if (insertedCoins.get(i)==1){
              realRejectedCoins.add("$1");
          }
          if (insertedCoins.get(i)==2){
              realRejectedCoins.add("$2");
          }
          if (insertedCoins.get(i)==5){
              realRejectedCoins.add("$5");
          }
          if (insertedCoins.get(i)==10){
              realRejectedCoins.add("$10");
          }
      }
      insertedCoins.clear();
      return realRejectedCoins;
  }

  public void addProduct(Product p) {
    products.add(p);
    productQuan.add(Integer.valueOf(products.get(products.size()-1).toString()));
    if (productQuan.size()==2){
        productQuan.add(0);
        productQuan.add(0);
    }
  }
  
	
  public void insertCoin(Integer c) {
    insertedCoins.add(c);
  }	
  
  public int totalCoins() {
	  int total = 0;
	  for (int i = 0; i < insertedCoins.size(); i++) {
		  total = total + insertedCoins.get(i);
	  }
	  return total - productQuan.get(2)*4 - productQuan.get(3)*5;
  }
  
  public ArrayList<String> rejectCoins(){
	  int current = totalCoins();
	  insertedCoins.clear();
	  int ten = current/10;
	  current = current - ten*10;
	  int five = current/5;
	  current = current - five*5;
	  int two = current/2;
	  current = current - two*2;
	  int one = current;
	  for (int i = 0; i < one;i++) {
		  rejectedCoins.add("$1");
	  }
	  for (int j = 0; j < two;j++) {
		  rejectedCoins.add("$2");
	  }
	  for (int k = 0; k < five;k++) {
		  rejectedCoins.add("$5");
	  }
	  for (int l = 0; l < ten;l++) {
		  rejectedCoins.add("$10");
	  }
	  return rejectedCoins;
  }
  
  public void clear() {
	  rejectedCoins.clear();
	  realRejectedCoins.clear();
  }
  
  public ArrayList<Integer> allProducts(){
	  return productQuan;
  }
  
  
  public void purchaseCola() {
	  productQuan.set(0, productQuan.get(0)-1);
	  productQuan.set(2, productQuan.get(2)+1);
  }
  
  public void purchasePepsi() {
	  productQuan.set(1, productQuan.get(1)-1);
	  productQuan.set(3, productQuan.get(3)+1);
  }
  
  public void reset() {
	  productQuan.set(2, 0);
	  productQuan.set(3, 0);
  }

  /* You may add other properties and methods */
}