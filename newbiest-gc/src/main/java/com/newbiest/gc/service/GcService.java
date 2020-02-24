package com.newbiest.gc.service;

import com.newbiest.base.exception.ClientException;
import com.newbiest.base.ui.model.NBOwnerReferenceList;
import com.newbiest.gc.model.*;
import com.newbiest.mms.dto.MaterialLotAction;
import com.newbiest.mms.model.DeliveryOrder;
import com.newbiest.mms.model.DocumentLine;
import com.newbiest.mms.model.MaterialLot;

import java.util.List;
import java.util.Map;

/**
 * Created by guoxunbo on 2019-08-21 12:41
 */
public interface GcService {

    void validationMLotReserved(MaterialLot materialLot) throws ClientException;
    void materialLotWeight(List<WeightModel> weightModels) throws ClientException;
    MaterialLot getWaitWeightMaterialLot(String materialLotId) throws ClientException;

    List<MaterialLot> getPackedDetailsAndNotReserved(List<String> packedLotRrn) throws ClientException;
    List<MaterialLot> getWaitForReservedMaterialLot(Long documentLineRrn, Long tableRrn)  throws ClientException;
    DocumentLine reservedMaterialLot(Long documentLineRrn, List<MaterialLotAction> materialLotActions, String stockNote) throws ClientException;
    void unReservedMaterialLot(List<MaterialLotAction> materialLotActions) throws ClientException;

    List<DeliveryOrder> recordExpressNumber(List<DeliveryOrder> deliveryOrders) throws ClientException;

    MaterialLot getWaitStockInStorageMaterialLot(String materialLotId) throws ClientException;
    void stockIn(List<StockInModel> stockInModels) throws ClientException;

    MesPackedLot findByPackedLotRrn(Long packedLotRrn) throws ClientException;
    List<MesPackedLot> findByParentRrn(Long parentRrn) throws ClientException;
    void receiveFinishGood(List<MesPackedLot> packedLotList) throws ClientException;

    void bindRelaxBox(List<MaterialLot> materialLots, String relaxBoxId) throws ClientException;
    void unbindRelaxBox(List<MaterialLot> materialLots) throws ClientException;

    void judgePackedMaterialLot(List<MaterialLot> materialLots, List<StockOutCheck> checkList) throws ClientException;

    List<NBOwnerReferenceList> getJudgePackCaseCheckList() throws ClientException;
    List<NBOwnerReferenceList> getStockOutCheckList() throws ClientException;
    void stockOutCheck(List<MaterialLot> materialLots, List<StockOutCheck> ngStockOutCheckList) throws ClientException;

    void asyncReceiveOrder() throws ClientException;
    void asyncShipOrder() throws ClientException;

    void asyncReTestOrder() throws ClientException;
    void asyncWaferIssueOrder() throws ClientException;

    void checkMaterialInventory(List<MaterialLot> existMaterialLots, List<MaterialLot> errorMaterialLots) throws ClientException;

    void validationDocLine(DocumentLine documentLine, MaterialLot materialLot) throws ClientException;
    void stockOut(DocumentLine documentLine, List<MaterialLotAction> materialLotActions) throws ClientException;
    void reTest(List<DocumentLine> documentLineList, List<MaterialLotAction> materialLotActions) throws ClientException;
    void validationMaterial(MaterialLot materialLotFirst,MaterialLot materialLot);
    List<DocumentLine> validationAndGetDocumentLineList(List<DocumentLine> documentLines, MaterialLot materialLot) throws ClientException;
    void asyncMesProduct() throws ClientException;

    List<Map> findEntityMapListByQueryName(String queryName, Map<String, Object> paramMap, int firstResult, int maxResult, String whereClause, String orderByClause) throws ClientException;
    List<MaterialLot>  getWaitChangeStorageMaterialLotByRelayBoxId(String relayBoxId) throws ClientException;
    void transferStorage(List<RelayBoxStockInModel> relayBoxStockInModel) throws  ClientException;
}
