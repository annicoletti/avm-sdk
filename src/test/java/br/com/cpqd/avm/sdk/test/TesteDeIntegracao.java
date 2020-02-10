package br.com.cpqd.avm.sdk.test;

import br.com.cpqd.avm.sdk.v1.builder.impl.Builder;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.service.api.Integration;

public class TesteDeIntegracao implements Integration {
	
	@Override
	public ResponseTO execute(RequestTO requestTO) throws SdkExceptions {
		
		ResponseTO to = Builder.RESPONSE
			.addStatus(true)
			.addRequestId(requestTO.getRequestId())
			.addResponse(Integration.KEY_DATA_MODEL, builderService.COLLECT().addMatch("Olá eu sou o SDK do AVM").build())
			.addResponse(KEY_EVENT_NAME, requestTO.getAction())
			.addResponse(KEY_STATUS, true)
			//.addResponse(KEY_ERROR_CODE, "0001") 
			//.addResponse(KEY_ERROR_MESSAGE,"DEU RUIM") 
			//.addCode("ERRO-001")				 
			//.addMessage("Erro de integração")
			.build();	
		
		return to;
	}

}
