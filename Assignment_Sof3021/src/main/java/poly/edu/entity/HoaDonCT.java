package poly.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HOADONCT")
public class HoaDonCT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="SOLUONG")
	private Integer soLuong;
	@Column(name="DONGIA")
	private float donGia;
	
	@OneToOne
	@JoinColumn(name = "ID_HOADON", referencedColumnName = "ID")
	private HoaDon hoadon;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product productHD;

	
	public HoaDonCT(Integer id, Integer soLuong, float donGia, HoaDon hoadon, Product productHD) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hoadon = hoadon;
		this.productHD = productHD;
	}

	public HoaDonCT() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public Product getProductHD() {
		return productHD;
	}

	public void setProductHD(Product productHD) {
		this.productHD = productHD;
	}

	
	
	
	
}
