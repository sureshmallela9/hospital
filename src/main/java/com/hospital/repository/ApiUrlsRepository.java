package com.hospital.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.ApiUrl;

@RepositoryRestResource(collectionResourceRel = "apiurls", path = "apiurls")
public interface ApiUrlsRepository extends CrudRepository<ApiUrl, Long> {
    public ApiUrl findById(long id);
    public List<ApiUrl> findAll();
}
