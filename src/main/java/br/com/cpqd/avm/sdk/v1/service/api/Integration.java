package br.com.cpqd.avm.sdk.v1.service.api;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.service.impl.BuilderServiceBean;

public interface Integration {

	public static final String KEY_DATA_MODEL = "datamodel";
	public static final String KEY_EVENT_NAME = "eventName";
	public static final String KEY_STATUS = "status";
	public static final String KEY_ERROR_CODE = "errorCode";
	public static final String KEY_ERROR_MESSAGE = "errorMessage";

	public static final BuilderService builderService = new BuilderServiceBean();

	public abstract ResponseTO execute(RequestTO requestTO) throws SdkExceptions;

}
