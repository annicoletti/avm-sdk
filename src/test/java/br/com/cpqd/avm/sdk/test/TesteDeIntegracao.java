package br.com.cpqd.avm.sdk.test;

import br.com.cpqd.avm.sdk.v1.builder.impl.Builder;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.Choices;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.service.api.Integration;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants.Type;

public class TesteDeIntegracao implements Integration {
	
	@Override
	public ResponseTO execute(RequestTO requestTO) throws SdkExceptions {
		
		Choices choices = builderService.CHOICES()
				.addImage("image")
				.addText("text")
				.addValue("value")
				.build();
		
		ResponseTO to = Builder.RESPONSE
			.addStatus(true)
			.addRequestId(requestTO.getRequestId())
			.addResponse(Integration.KEY_DATA_MODEL, choices)
			.addResponse(KEY_EVENT_NAME, requestTO.getAction())
			.addResponse(KEY_STATUS, true)
			.addResponse("type","SIMPLE_MESSAGE")
			//.addResponse(KEY_ERROR_CODE, "0001") 
			//.addResponse(KEY_ERROR_MESSAGE,"DEU RUIM") 
			//.addCode("ERRO-001")				 
			//.addMessage("Erro de integração")
			.build();	
		
		ResponseTO to2 = Builder.RESPONSE_SUCESS
				.addStatus(false)
				.addRequestId(requestTO)
				.addDataModel(choices)
				.addEventName(requestTO)
				.addType(Type.CHOICES)
				.build();
		
		return to;
	}

}
