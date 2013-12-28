package dbManager;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class OrderedDrug {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    public Key key;

	@Persistent
	public String name;
	@Persistent
	public double price;
	@Persistent
	public int quantity;
	@Persistent
	private Order order;
										
	public OrderedDrug (String n, double p, int q) {
		name = n;
		price = p;
		quantity = q;
	}
										
	public String getName() {return name;}
	public double getPrice() {return price;}
	public int getQuantity() {return quantity;}
	public void setQuantity(int q) {
		quantity = q;
		price *= q;
	}
	public void addQuantity(int q) {
		double unitPrice = price / quantity;
		quantity += q;
		price = unitPrice * quantity;
	}
	public boolean equals(OrderedDrug drug) {return (name.equals(drug.name));}
										
}
