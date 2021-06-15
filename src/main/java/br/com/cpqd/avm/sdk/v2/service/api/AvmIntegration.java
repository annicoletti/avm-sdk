package br.com.cpqd.avm.sdk.v2.service.api;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v2.model.to.AvmRequestTO;
import br.com.cpqd.avm.sdk.v2.model.to.AvmResponseTO;

public interface AvmIntegration {

	public abstract AvmResponseTO execute(AvmRequestTO requestTO) throws SdkExceptions;

}
