package nl.edu.avans.ivp4c2.domain;

import java.util.ArrayList;

/**
 * A Table has Orders and Orders have Products
 * 
 * @author IVP4C2
 */


public class Table {
	private int tableNumber;
	private String tableStatus;
	private ArrayList<Order> orders;
	
	public Table(int tableNumber, String tableStatus) {
		this.tableNumber = tableNumber;
		this.tableStatus = tableStatus;
		ArrayList<Order> orders = new ArrayList<Order>();
	}
	
	//Getters
	public int getTableNumber() {
		return tableNumber;
	}
	
	public String getTableStatus() {
		return tableStatus;
	}

	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	//Setters
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	
	//Print methods
	public String toString() {
		return String.format("%-20s %-20s %-20s", tableNumber, tableStatus);
	}
	
	public void print() {
		System.out.println(tableNumber + tableStatus);
	}
}
