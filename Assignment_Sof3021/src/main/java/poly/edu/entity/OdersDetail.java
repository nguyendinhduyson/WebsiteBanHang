package poly.edu.entity;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERDETAILS")
public class OdersDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer id;
	@Column(name = "PRICE")
	private float price;
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    private Oders oders;


	public OdersDetail(Integer id, float price, Integer quantity, Product product, Oders oders) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.oders = oders;
	}


	public OdersDetail() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Oders getOders() {
		return oders;
	}


	public void setOders(Oders oders) {
		this.oders = oders;
	}





	
	
	

}
