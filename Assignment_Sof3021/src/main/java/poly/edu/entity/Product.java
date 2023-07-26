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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer id;
	@NotBlank(message = "Vui long nhap name")
	@Column(name = "NAME")
	private String name;
	@NotNull(message = "Vui long nhap price")
	@Column(name = "PRICE")
	private float price;
	@NotBlank(message = "Vui long nhap description")
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "IMAGE")
	private String image;

	@ManyToOne
	@JoinColumn(name="CATEGORY_ID", referencedColumnName = "ID")
	private Category category;
	
	
	@OneToOne(mappedBy = "product")
	private OdersDetail orderdetail;

	
	@OneToMany(mappedBy = "productHD")
	List<HoaDonCT> listHDCT = new ArrayList<>();

//	public Product(Integer id, @NotBlank(message = "Vui long nhap name") String name,
//			@NotNull(message = "Vui long nhap price") float price,
//			@NotBlank(message = "Vui long nhap description") String description, String image, Category category,
//			OdersDetail orderdetail) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.description = description;
//		this.image = image;
//		this.category = category;
//		this.orderdetail = orderdetail;
//	}


	public Product() {
		super();
	}


	public Product(Integer id, @NotBlank(message = "Vui long nhap name") String name,
			@NotNull(message = "Vui long nhap price") float price,
			@NotBlank(message = "Vui long nhap description") String description, String image, Category category,
			OdersDetail orderdetail, List<HoaDonCT> listHDCT) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.category = category;
		this.orderdetail = orderdetail;
		this.listHDCT = listHDCT;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public OdersDetail getOrderdetail() {
		return orderdetail;
	}


	public void setOrderdetail(OdersDetail orderdetail) {
		this.orderdetail = orderdetail;
	}


	public List<HoaDonCT> getListHDCT() {
		return listHDCT;
	}


	public void setListHDCT(List<HoaDonCT> listHDCT) {
		this.listHDCT = listHDCT;
	}
	
	
	
	
}
