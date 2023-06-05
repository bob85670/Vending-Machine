import java.util.ArrayList;

public class CmdRejectCoins implements Command {
	private ArrayList<String> coinleft;

  @Override
  public String execute(VendingMachine v, String cmdPart) {
	  int c = v.totalCoins();
	  coinleft = new ArrayList<String>(v.realRejectCoins());
	  if (coinleft.size() > 0) {
		  String str = coinleft.toString().replace("[", "").replace("]", "");
		  coinleft.clear();
		  v.clear();
		  return "Rejected " + str + ". $" + c + " in total.";
	  }
	  else{
		  return "Rejected no coin!";
	  }
  }
}