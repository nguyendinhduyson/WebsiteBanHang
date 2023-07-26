package poly.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.OdersDetail;


public interface OrderDetailRepository extends JpaRepository<OdersDetail, Integer>{

	

//	List<OdersDetail> listOrderdetailByOrderId(Integer id);
//
//	
//	
    @Query(value="select o from OdersDetail o where o.oders.id = ?1")
	List<OdersDetail> findByOders(Integer id);
    @Query(value="select o from OdersDetail o where o.product.id = ?1")
    OdersDetail getorderdetail(Integer idPD);
}
