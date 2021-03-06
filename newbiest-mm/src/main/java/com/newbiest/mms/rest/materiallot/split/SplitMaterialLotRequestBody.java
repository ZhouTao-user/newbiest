package com.newbiest.mms.rest.materiallot.split;

import com.newbiest.base.msg.RequestBody;
import com.newbiest.mms.dto.MaterialLotAction;
import com.newbiest.mms.model.MaterialLot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("具体请求操作信息")
public class SplitMaterialLotRequestBody extends RequestBody {
	
	private static final long serialVersionUID = 1L;

	private MaterialLotAction materialLotAction;

}
