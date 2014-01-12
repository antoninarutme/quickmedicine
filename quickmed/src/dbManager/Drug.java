package dbManager;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Drug {
	
	@PrimaryKey
	public String name;
	@Persistent
	public double MeuhedetPrice;
	@Persistent
	public double LeumitPrice;
	@Persistent
	public double ClalitPrice;
	@Persistent
	public double MaccabiPrice;
	@Persistent
	public double HMOlessPrice;
	@Persistent
	public int quantity;
	@Persistent
	public int virtualQuantity;	
	//virtual quantity = actual quantity - quantity ordered by clients but not sold yet
	
	public String getName() {return name;}
	
	public double getPrice (String s) {
		if (s.equals("Meuhedet"))
			return MeuhedetPrice;
		else if (s.equals("Leumit"))
			return LeumitPrice;
		else if (s.equals("Clalit"))
			return ClalitPrice;
		else if (s.equals("Maccabi"))
			return MaccabiPrice;
		else
			return HMOlessPrice;
	}

	public int getQuantity() {return quantity;}
	
	public void addQuantity (int q) {
		quantity += q;
		virtualQuantity += q;
	}
	
	public void order(int q) {
		if (q <= virtualQuantity)
			virtualQuantity -= q;
	}
	
	public boolean isInInventory() {return (quantity != 0);}
	
	public boolean enoughInInventory(int q) {return (q <= virtualQuantity);}

}
