package com.samsteele.store.face;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.samsteele.store.model.inventory;

@RepositoryRestResource
public interface invyTable  extends CrudRepository<inventory, Integer> {

	@Query(value="Select * from inventory where price <= :price", nativeQuery=true)
	Iterable<inventory> belowPrive(@Param("price")int price);

	@Query(value="Select * from inventory where price >= :price", nativeQuery=true)
	Iterable<inventory> abovePrive(@Param("price")int price);
	
	@Query(value="Select * from inventory where price <= :hi and price >= :low", nativeQuery=true)
	Iterable<inventory> betweenPrive(@Param("low")int low,@Param("hi") int hi);
	
	Iterable<inventory> findByPriceBetween(int hi, int low);

	Iterable<inventory> findByType(String type);
	
	@Query(value="Select * from inventory where itemname like :name", nativeQuery=true)
	Iterable<inventory> findLikeName(@Param("name") String type);
	
	Iterable<inventory> findByItemnameLike(String name);

	@Query(value="SELECT quantity as [invyID] ,[itemname] ,[price],[description],[type]FROM [inventory] join ole on invyfk = invyID where orderfk = :OID", nativeQuery=true)
	Iterable<inventory> viewLineItems(@Param("OID")int oid);
	
}
