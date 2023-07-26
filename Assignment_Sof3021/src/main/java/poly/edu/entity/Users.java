package poly.edu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
//	@NotBlank(message = "Vui lòng nhập name")
	@Column(name = "NAME")
	private String name;
	@NotBlank(message = "Vui lòng nhập username")
	@Column(name = "USERNAME")
	private String username;
	@NotBlank(message = "Vui lòng nhập password")
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "REMEMBERME")
	private Boolean rememberMe;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private RoleEnum role;
	@OneToOne(mappedBy = "users")
	private Oders orders;

	@OneToMany(mappedBy = "users")
	private List<HoaDon> listHD = new ArrayList<>();
//	public Users() {
//
//	}
//	public Users(Integer id, String name, @NotBlank(message = "Vui lòng nhập username") String username,
//			@NotBlank(message = "Vui lòng nhập password") String password, Boolean rememberMe, Oders orders) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.username = username;
//		this.password = password;
//		this.rememberMe = rememberMe;
//		this.orders = orders;
//	}

	public Users(Integer id, String name, @NotBlank(message = "Vui lòng nhập username") String username,
			@NotBlank(message = "Vui lòng nhập password") String password, Boolean rememberMe, RoleEnum role,
			Oders orders, List<HoaDon> listHD) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.rememberMe = rememberMe;
		this.role = role;
		this.orders = orders;
		this.listHD = listHD;
	}

	public Users() {
		super();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public Oders getOrders() {
		return orders;
	}

	public void setOrders(Oders orders) {
		this.orders = orders;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

}
