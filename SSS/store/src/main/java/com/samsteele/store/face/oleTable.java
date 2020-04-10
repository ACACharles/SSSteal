package com.samsteele.store.face;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.samsteele.store.model.ole;

@RepositoryRestResource
public interface oleTable extends CrudRepository<ole, Integer> {

}
