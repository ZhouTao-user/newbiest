package com.newbiest.mms.repository;

import com.newbiest.base.exception.ClientException;
import com.newbiest.base.repository.custom.IRepository;
import com.newbiest.mms.model.MaterialLotInventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guoxunbo on 2019/2/20.
 */
@Repository
public interface MaterialLotInventoryRepository extends IRepository<MaterialLotInventory, Long> {

    /**
     * 一个仓库的库位上只能存在一个相同名称的物料批次
     */
    MaterialLotInventory findByMaterialLotRrnAndWarehouseRrnAndStorageRrn(long materialLotRrn, long warehouseRrn, long storageRrn) throws ClientException;

    @Query("SELECT MaterialLotInventory FROM MaterialLotInventory MaterialLotInventory WHERE MaterialLotInventory.materialLotRrn = :materialLotRrn AND MaterialLotInventory.warehouseRrn = :warehouseRrn " +
            " AND MaterialLotInventory.storageRrn IS NULL")
    MaterialLotInventory findByMaterialLotRrnAndWarehouseRrnAndStorageIsNull(long materialLotRrn, long warehouseRrn) throws ClientException;


    /**
     * 根据物料批次或者物料批次对应的所有仓库
     */
    List<MaterialLotInventory> findByMaterialLotRrn(long materialLotRrn) throws ClientException;

}
