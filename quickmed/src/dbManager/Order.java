package dbManager;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Element;

import java.util.LinkedList;
import java.util.Calendar;
import java.util.TimeZone;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Order {
	@PrimaryKey
	public String orderID;
	@Persistent
	public int clientID;
	@Persistent
	public int month;
	@Persistent
	public int date;
	@Persistent
	public int from_hour;
	@Persistent
	public int to_hour;
	@Persistent(mappedBy = "order")
	@Element(dependent = "true")
	public LinkedList<OrderedDrug> list;
	public String HMO;
	@Persistent
	public double price;

	public Order (int id, String hmo) {
		clientID = id;
		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+2:00"));
		date = now.get(Calendar.DATE);
		month = now.get(Calendar.MONTH) + 1;
		int currentDay = now.get(Calendar.DAY_OF_WEEK);
		int year = now.get(Calendar.YEAR);
		//if it's friday and it's too late (12 pm)
		if (currentDay == 6 && now.get(Calendar.HOUR_OF_DAY) >= 12)
			date += 2;
		//if it's too late (8 pm) or it's shabbat:
		else if (currentDay == 7 || now.get(Calendar.HOUR_OF_DAY) >= 20)
			date++;
		//february:
		if (isFebruary(month)) {
			if ((leapYear(year) && date == 29) || (!leapYear(year) && date == 30)) {
				date = 1;
				month++;
			}
			if ((leapYear(year) && date == 30) || (!leapYear(year) && date == 31)) {
				date = 2;
				month++;
			}
		}
		//months of 30 days
		else if (thirtyDaysMonth(month)) {
			if (date == 31) {
				date = 1;
				month++;
			}
			if (date == 32) {
				date = 2;
				month++;
			}
		}
		//months of 31 days
		else {
			if (date == 32) {
				date = 1;
				month++;
			}
			if (date == 33) {
				date = 2;
				month++;
			}
			if (month == 13)
				month = 1;
		}
		HMO = hmo;
		orderID = "" + id + date + month + year;
		price = 0;
		list = new LinkedList<OrderedDrug>();
	}

	public double getPrice() {return price;}
	public LinkedList<OrderedDrug> getDrugs() {return list;}
	
	public void setHours (int fh, int th) {
		from_hour = fh;
		to_hour = th;
	}
	
	public void add(OrderedDrug d) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).equals(d)) {
				//double unitPrice = list.get(i).price / list.get(i).quantity;
				list.get(i).addQuantity(d.quantity);
				System.out.println ("old drug in order, quantity: "+d.quantity);
				price += d.price;
				return;
			}
		}
		list.addLast(d);
		price += d.price;
		System.out.println ("new drug in order, quantity: "+d.quantity);
	}
	
	private boolean leapYear (int year) {
		return (year%4 == 0);}
	
	private boolean thirtyDaysMonth (int month) {
		return ((month == 4 || month == 6 || month == 9 || month == 11));
	}
	
	private boolean isFebruary (int month) {
		return (month == 2);
	}
	
	public String printDate ()
	{
		String s = "" + date + "/" + month;
		return s;
	}

	/*public void remove(String s) {
		OrderedDrug d = new OrderedDrug(s,0,0);
		int i = list.indexOf(d);
		if (i != -1) {
			price -= list.get(i).getPrice()*list.get(i).getQuantity();
			list.remove(i);
		}		
	}*/
	
}