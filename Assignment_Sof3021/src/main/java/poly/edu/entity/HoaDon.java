package poly.edu.entity;

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
@Table(name = "HOADON")
public class HoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NGAYTAO")
	private String ngayTao;
	@Column(name = "NGAYTHANHTOAN")
	private String ngayThanhToan;
	@Column(name = "TENNGUOINHAN")
	private String tenNguoiNhan;
	
	@ManyToOne
	@JoinColumn(name = "ID_USERS", referencedColumnName = "ID")
	private Users users;
	
	@OneToOne
	private HoaDonCT hoadonCT;

	public HoaDon(Integer id, String ngayTao, String ngayThanhToan, String tenNguoiNhan, Users users,
			HoaDonCT hoadonCT) {
		super();
		this.id = id;
		this.ngayTao = ngayTao;
		this.ngayThanhToan = ngayThanhToan;
		this.tenNguoiNhan = tenNguoiNhan;
		this.users = users;
		this.hoadonCT = hoadonCT;
	}

	public HoaDon() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}

	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public HoaDonCT getHoadonCT() {
		return hoadonCT;
	}

	public void setHoadonCT(HoaDonCT hoadonCT) {
		this.hoadonCT = hoadonCT;
	}
	
	
	
	
}
