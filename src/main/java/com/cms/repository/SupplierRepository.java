package com.cms.repository;

import com.cms.entity.Supplier;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "supplier",path="supplier")
public interface SupplierRepository extends BaseRepository<Supplier> {
}
