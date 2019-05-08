package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	
	// Constructors
	public Order() {		
	}

	public Order(Date moment, OrderStatus status) {		
		this.moment = moment;
		this.status = status;		
	}

	// Getters and Setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public double total() {
		
		double sum = 0;
		
		for (OrderItem item : this.items) {
			
			sum += item.subTotal();
		}		
		
		return sum;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(this.getMoment()) + "\n");
		sb.append("Order status: " + this.getStatus());
		return sb.toString();
	}
}
