package com.samsteele.store.face;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import com.samsteele.store.model.orderlist;

@RepositoryRestResource
public interface orderTable   extends CrudRepository<orderlist, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="insert into [orderlist] (clientfk, isfinal, itemcount, name, totalprice) values (:CID, 'false', 0, :oName ,0)", nativeQuery=true)
	void AddCust(@Param("CID")int CID, @Param("oName") String oName);
	
	@Query(value="select top 1 * from [orderlist] order by orderid desc", nativeQuery=true)
	orderlist lastAdded();

	@Query(value="select  * from [orderlist] WHERE orderid = :id", nativeQuery=true)
	Optional<orderlist> findById(@Param("id")Integer id);
	
	default orderlist UOI(Integer prices, Integer count,Integer oid) {
		//this.upd(prices, count,oid);
		return findById(oid).get();
		
	}

		
	@Modifying
	@Query(value="update [orderlist] set totalprice = :tp, itemcount = :ic where orderid = :oid", nativeQuery=true)
	void upd(@Param("tp")Integer prices, @Param("ic")Integer count, @Param("oid")Integer oid);
	
}
	