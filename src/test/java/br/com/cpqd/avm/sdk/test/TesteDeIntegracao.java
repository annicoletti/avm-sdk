package br.com.cpqd.avm.sdk.test;

import org.json.JSONObject;

import br.com.cpqd.avm.sdk.v1.builder.impl.ResponseBuilder;
import br.com.cpqd.avm.sdk.v1.enums.EnumResponseError;
import br.com.cpqd.avm.sdk.v1.enums.EnumType;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.Choices;
import br.com.cpqd.avm.sdk.v1.model.to.RequestAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;
import br.com.cpqd.avm.sdk.v1.service.api.Integration;

public class TesteDeIntegracao implements Integration {
	
	@Override
	public ResponseAvmTO execute(RequestAvmTO requestTO) throws SdkExceptions {
		
		
		Choices choices = DataModelBuilder.CHOICES()
				.addImage("image")
				.addText("text")
				.addValue("value")
				.build();
		
		
			ResponseAvmTO to = ResponseBuilder.RESPONSE_SUCCESS
					.addRequestId(requestTO)
					.addDataModel(choices)
					.addEventName(requestTO)
					.addType(EnumType.TRANSFER)
					.addResponseWithError(EnumResponseError.STATUS, false)
					.addResponseWithError(EnumResponseError.ERROR_CODE, "ERR-001")
					.addResponseWithError(EnumResponseError.ERROR_MESSAGE, "mensagem...")
					.build();
			
			System.out.println(new JSONObject(to).toString());			
		 
			ResponseAvmTO too = ResponseBuilder.RESPONSE_ERROR
					.addCode("CODE")
					.addMessage("MESSAGE")
					.addRequestId(requestTO)
					.build();
			
			System.out.println(new JSONObject(too).toString());
		
			return null;
	}

}
