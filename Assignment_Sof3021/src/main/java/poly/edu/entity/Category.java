package poly.edu.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@NotBlank(message = "Vui long nhap name")
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> listPD = new ArrayList<>(); 
	
	public Category() {
		
	}

	public Category(Integer id, @NotBlank(message = "Vui long nhap name") String name, List<Product> listPD) {
		super();
		this.id = id;
		this.name = name;
		this.listPD = listPD;
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

	public List<Product> getListPD() {
		return listPD;
	}

	public void setListPD(List<Product> listPD) {
		this.listPD = listPD;
	}

	
}
