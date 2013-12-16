package dbManager;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.util.LinkedList;


import java.util.Calendar;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Order {
	@PrimaryKey
	private String orderID;
	@Persistent
	private int clientID;
	@Persistent
	private int month;
	@Persistent
	private int date;
	@Persistent
	private int from_hour;
	@Persistent
	private int to_hour;
	@Persistent
	private LinkedList<OrderedDrug> list;
	private String HMO;
	@Persistent
	private int price;
	
	public class OrderedDrug {
		private String name;
		private int price;
		private int quantity;
											
		OrderedDrug (String n, int p, int q) {
			name = n;
			price = p;
			quantity = q;
		}
											
		public String getName() {return name;}
		public int getPrice() {return price;}
		public int getQuantity() {return quantity;}
		public void setQuantity(int q) {quantity = q;}
		public void addQuantity(int q) {quantity += q;}
		public boolean equals(OrderedDrug drug) {return (name.equals(drug.name));}
											
	}


	public Order (int id, String hmo) {
		clientID = id;
		date = Calendar.DATE;
		month = Calendar.MONTH + 1;
		int currentDay = Calendar.DAY_OF_WEEK;
		int year = Calendar.YEAR;
		//if it's too late (9 pm) or it's friday and it's too late (1 pm) or it's shabbat:
		if (currentDay == 7
				|| (currentDay == 6 && Calendar.HOUR_OF_DAY >= 13)
				|| Calendar.HOUR_OF_DAY >= 21) {
			date++;
			//february:
			if (month == 2) {
				if ((year % 4 != 0 && date == 29) || (year % 4 == 0 && date == 30)) {
					date = 1;
					month++;
				}
			}
			//months of 30 days
			else if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (date == 31) {
					date = 1;
					month++;
				}
			}
			else {
				if (date == 32) {
					date = 1;
					month++;
					if (month == 13)
						month = 1;
				}
			}
		}
		HMO = hmo;
		orderID = "" + id + Calendar.DAY_OF_MONTH + Calendar.MONTH + Calendar.YEAR;
		price = 0;
		list = new LinkedList<OrderedDrug>();
	}

	public int getPrice() {return price;}
	
	public void setHours (int fh, int th) {
		from_hour = fh;
		to_hour = th;
	}

	public void add(String s, int quantity) {
		int p = DataStoreDatabaseManager.getInstance().getDrugByName(s).getPrice(HMO);
		OrderedDrug d = new OrderedDrug (s, p, quantity);
		int i = list.indexOf(d);
		if (i == -1)
			list.addLast(d);
		else
			list.get(i).addQuantity(d.getQuantity());
		price += d.getPrice()*d.getQuantity();
	}
	
	/*public void add(OrderedDrug d) {
		int i = list.indexOf(d);
		if (i == -1)
			list.addLast(d);
		else
			list.get(i).addQuantity(d.getQuantity());
		price += d.getPrice()*d.getQuantity();
	}*/


	public void remove(String s) {
		OrderedDrug d = new OrderedDrug(s,0,0);
		int i = list.indexOf(d);
		if (i != -1) {
			price -= list.get(i).getPrice()*list.get(i).getQuantity();
			list.remove(i);
		}		
	}	
	
}