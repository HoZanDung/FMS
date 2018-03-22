package com.cms.repository;

import com.cms.entity.SysDrug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by HOZANDUNG on 18/3/5.
 */
public interface SysDrugRepository extends BaseRepository<SysDrug> {

    /**
     * 根据名字查找
     *
     * @param name
     * @return
     */
    SysDrug findByName(String name);

    /**
     * 药品类型
     *
     * @param type
     * @return
     */
    List<SysDrug> findAllByType(String type);

    /**
     * 药品零售价格
     *
     * @param retailPrice
     * @return
     */
    List<SysDrug> findAllByRetailPrice(String retailPrice);

    /**
     * 药品进货价格
     *
     * @param replenishPrice
     * @return
     */
    List<SysDrug> findAllByReplenishPrice(String replenishPrice);

    /**
     * 剂型
     *
     * @param dosage
     * @return
     */
    List<SysDrug> findAllByDosage(String dosage);

    /**
     * 单位
     *
     * @param unit
     * @return
     */
    List<SysDrug> findAllByUnit(String unit);

    /**
     * 批号
     *
     * @param batchNumber
     * @return
     */
    List<SysDrug> findAllByBatchNumber(String batchNumber);

    /**
     * 经营方式
     *
     * @param operation
     * @return
     */
    List<SysDrug> findAllByOperation(String operation);

    /**
     * 产地
     *
     * @param origin
     * @return
     */
    List<SysDrug> findAllByOrigin(String origin);


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


    Page<SysDrug> findByNameContainingAndTypeContaining(@Param("name") String name, @Param("type") String type, Pageable pageable);
}
