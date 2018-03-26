package com.cms.repository;

import com.cms.entity.SysDrug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by HOZANDUNG on 18/3/5.
 */
public interface SysDrugRepository extends BaseRepository<SysDrug> {


    @RestResource(path = "nameContain", rel = "nameContain")
    Page<SysDrug> findAllByNameContaining(@Param("name") String name, Pageable pageable);

    Page<SysDrug> findAllByNameContainingAndTypeContainingAndBatchNumberContainingAndIntroduceContainingAndDrugbarContainingAndGenericNameContainingAndPinyinCodeContainingAndRetailPriceContainingAndReplenishPriceContainingAndUnitContainingAndDosageContainingAndValidityContainingAndQualityStandardContainingAndOperationContainingAndBatchNumberContaining(
            @Param("name") String name,
            @Param("type") String type,
            @Param("introduce") String introduce,
            @Param("drugbar") String drugbar,
            @Param("genericName") String genericName,
            @Param("pinyinCode") String pinyinCode,
            @Param("retailPrice") String retailPrice,
            @Param("replenishPrice") String replenishPrice,
            @Param("unit") String unit,
            @Param("dosage") String dosage,
            @Param("origin") String origin,
            @Param("validity") String validity,
            @Param("qualityStandard") String qualityStandard,
            @Param("operation") String operation,
            @Param("batchNumber") String batchNumber,
            Pageable pageable
    );

}
