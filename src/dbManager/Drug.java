package dbManager;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Drug {
	
	@PrimaryKey
	private String name;
	@Persistent
	private int MeuhedetPrice;
	@Persistent
	private int LeumitPrice;
	@Persistent
	private int ClalitPrice;
	@Persistent
	private int MaccabiPrice;
	@Persistent
	private int HMOlessPrice;
	@Persistent
	private int quantity;
	@Persistent
	public int virtualQuantity;	
	//virtual quantity = actual quantity - quantity ordered by clients but not sold yet
	
	/*public Drug() {}
	
	public Drug(String n, int p1, int p2, int p3, int p4, int p5, int q) {
		name = n;
		MeuhedetPrice = p1;
		LeumitPrice = p2;
		ClalitPrice = p3;
		MaccabiPrice = p4;
		HMOlessPrice = p5;
		quantity = q;
		virtualQuantity = q;
	}*/
	
	public String getName() {return name;}
	
	public int getPrice (String s) {
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
