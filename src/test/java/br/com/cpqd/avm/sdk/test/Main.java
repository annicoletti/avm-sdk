package br.com.cpqd.avm.sdk.test;

import br.com.cpqd.avm.sdk.v1.builder.impl.ResponseBuilder;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;

public class Main {

	@SuppressWarnings("unused")
	private static RequestAvmTO requestTOO;

	public static void main(String[] args) throws SdkExceptions {

		TesteDeIntegracao teste = new TesteDeIntegracao();

		RequestAvmTO requestTO = ResponseBuilder.REQUEST
				.addAction("GET_WEATHER")
				.addCompany("00999888800000")
				.addPortfolio("DEMOAV")
				.addRequestId("ID_00001")
				.addToken("9049503458039485034959340")
				.build();
		
		requestTOO = ResponseBuilder.REQUEST
				.addAction("GET_WEATHER")
				.addCompany("00999888800000")
				.addPortfolio("DEMOAV")
				.addRequestId("ID_00001")
				.addToken("9049503458039485034959340")
				.build();
		
		@SuppressWarnings("unused")
		ResponseAvmTO to = teste.execute(requestTO);
	}

}
