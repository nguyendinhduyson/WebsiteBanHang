package poly.edu.entity;

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
@Table(name = "ORDERS")
public class Oders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
   private Integer id;
	@Column(name="DATE")
   private String date;
	@Column(name="ADDRESS")
   private String address;

	@ManyToOne
	@JoinColumn(name = "ID_USERS", referencedColumnName = "ID")
    private Users users;
	
	@OneToMany(mappedBy = "oders")
	private List<OdersDetail> listOrderDetail;

	public Oders(Integer id, String date, String address, Users users, List<OdersDetail> listOrderDetail) {
		super();
		this.id = id;
		this.date = date;
		this.address = address;
		this.users = users;
		this.listOrderDetail = listOrderDetail;
	}

	public Oders() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<OdersDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OdersDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	
	
	
	
}
