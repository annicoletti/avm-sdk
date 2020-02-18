package br.com.cpqd.avm.sdk.v1.builder.api;

import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;

public interface DataModel {

	default String getDataModelKey() {
		return SdkConstants.DataModel.DATA_MODEL;
	}
	
    String getDataModelValue();
	
}
