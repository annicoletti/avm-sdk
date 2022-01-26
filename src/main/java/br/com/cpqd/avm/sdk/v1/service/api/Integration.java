package br.com.cpqd.avm.sdk.v1.service.api;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;
import br.com.cpqd.avm.sdk.v1.service.impl.BuilderServiceBean;

public interface Integration {

	public static final BuilderService DataModelBuilder = new BuilderServiceBean();

	public abstract ResponseAvmTO execute(RequestAvmTO requestTO) throws SdkExceptions;

}
