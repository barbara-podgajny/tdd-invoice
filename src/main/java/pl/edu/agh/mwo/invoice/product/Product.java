package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product (String name, BigDecimal price, BigDecimal tax) {
		if(name == null || name.equals("")){
			throw new IllegalArgumentException("Name cannot be null");
		}
		
		if(price == null || price.equals("")) {
			throw new IllegalArgumentException("Price cannot be null");
		}
		
	if (price == null || price.compareTo(new BigDecimal("0")) <= 0) {
		throw new IllegalArgumentException("Price cannot be negative");
	}
		
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}


	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		
		return price.add(this.price.multiply(this.taxPercent));
	}
}
