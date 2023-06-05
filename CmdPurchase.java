import java.util.ArrayList;
public class CmdPurchase implements Command {
	private ArrayList<String> newcoinleft;

  @Override
  public String execute(VendingMachine v, String cmdPart) {
	  
	  if (cmdPart.equalsIgnoreCase("Pepsi")) {
		  if (v.allProducts().get(1) > 0 && v.totalCoins()>5) {
			  v.purchasePepsi();
			  int c = v.totalCoins();
			  newcoinleft = new ArrayList<String>(v.rejectCoins());
			  String str = newcoinleft.toString().replace("[", "").replace("]", "");
			  v.clear();
			  v.reset();
			  return "Dropped Pepsi. Paid $" + (c+5) +". Your change: " + str + ".";
		  }
		  if (v.allProducts().get(1) > 0 && v.totalCoins()==5) {
			  v.purchasePepsi();
			  int c = v.totalCoins();
			  newcoinleft = new ArrayList<String>(v.rejectCoins());
			  String str = newcoinleft.toString().replace("[", "").replace("]", "");
			  v.clear();
			  v.reset();
			  return "Dropped Pepsi. Paid $" + (c+5) +". No change.";
		  }
		  if (v.allProducts().get(1) > 0 && v.totalCoins()<5) {
			  int c = v.totalCoins();
			  return "Not enough credit to buy Pepsi! Inserted $" + c + " but needs $5.";
		  }
		  if (v.allProducts().get(1) == 0) {
			  return "Pepsi is out of stock!";
		  }
	  }
	  if (cmdPart.equalsIgnoreCase("Cocacola")) {
		  if (v.allProducts().get(0) > 0 && v.totalCoins()>4) {
			  v.purchaseCola();
			  int c = v.totalCoins();
			  newcoinleft = new ArrayList<String>(v.rejectCoins());
			  String str = newcoinleft.toString().replace("[", "").replace("]", "");
			  v.clear();
			  v.reset();
			  return "Dropped Cocacola. Paid $" + (c+4) +". Your change: " + str + ".";
		  }
		  if (v.allProducts().get(0) > 0 && v.totalCoins()==4) {
			  v.purchaseCola();
			  int c = v.totalCoins();
			  newcoinleft = new ArrayList<String>(v.rejectCoins());
			  String str = newcoinleft.toString().replace("[", "").replace("]", "");
			  v.clear();
			  v.reset();
			  return "Dropped Cocacola. Paid $" + (c+4) +". No change.";
		  }
		  if (v.allProducts().get(0) > 0 && v.totalCoins()<4) {
			  int c = v.totalCoins();
			  return "Not enough credit to buy Cocacola! Inserted $" + c + " but needs $4.";
		  }
		  if (v.allProducts().get(0) == 0) {
			  return "Cocacola is out of stock!";
		  }
	  }
	  return "";
  }
}