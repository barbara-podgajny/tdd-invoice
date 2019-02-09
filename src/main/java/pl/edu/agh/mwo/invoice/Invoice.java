package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	
	private BigDecimal subTotal;
	private BigDecimal tax;
	private BigDecimal total;
	
	Product product;
	
	private Collection<Product> products;

	public void addProduct(Product product) {
		this.addProduct(product, 1);
		}
	
	public void addProduct(Product product, Integer quantity) {
		for (int i=0; i<quantity; i++) {
			this.products.add(product);
			
		}	
	}

	public BigDecimal getSubtotal() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : this.products) {
			sum = sum.add(product.getPrice());
		}
		return sum;
	}

	public BigDecimal getTax() {
		BigDecimal tax = BigDecimal.ZERO;
		return tax;
	}

	public BigDecimal getTotal() {
		return total;
	}
}
