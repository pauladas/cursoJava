package entities;

public class Product {

	private String name;
	private int qtd;
	private double price;

	public Product(String name, int qtd, double price) {
		super();
		this.name = name;
		this.qtd = qtd;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getQtd() {
		return qtd;
	}

	public double getPrice() {
		return price;
	}

	private double getTotal() {
		return (double) qtd * price;
	}

	@Override
	public String toString() {
		return name + "," + String.format("%.2f", getTotal());
	}

}
