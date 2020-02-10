package br.com.cpqd.avm.sdk.test;

import org.json.JSONObject;

import br.com.cpqd.avm.sdk.v1.builder.impl.Builder;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;

public class Main {

	public static void main(String[] args) throws SdkExceptions {

		TesteDeIntegracao teste = new TesteDeIntegracao();

		RequestTO requestTO = Builder.REQUEST
				.addAction("GET_WEATHER")
				.addCompany("00999888800000")
				.addPortfolio("DEMOAV")
				.addRequestId("TESTE_ID")
				.addToken("9049503458039485034959340")
				.build();
		
		ResponseTO to = teste.execute(requestTO);

		JSONObject json = new JSONObject(to);
		System.out.println(json);
	}

}
