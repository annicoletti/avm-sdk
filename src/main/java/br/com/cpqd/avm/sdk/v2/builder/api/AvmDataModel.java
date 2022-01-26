package br.com.cpqd.avm.sdk.v2.builder.api;

import br.com.cpqd.avm.sdk.v2.enums.AvmDataModelType;

public interface AvmDataModel {

	public AvmDataModelType getType();

	public Object getDataModel();

}
