package br.com.cpqd.avm.sdk.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.cpqd.avm.sdk.v1.builder.impl.Builder;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.Choices;
import br.com.cpqd.avm.sdk.v1.model.to.Collect;
import br.com.cpqd.avm.sdk.v1.model.to.Content;
import br.com.cpqd.avm.sdk.v1.model.to.Menu;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseErrorTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseSuccessTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.model.to.ShortText;
import br.com.cpqd.avm.sdk.v1.model.to.Voice;
import br.com.cpqd.avm.sdk.v1.service.api.Integration;

public class TesteDataModel implements Integration {

	@Test
	public void dataModelVoice() {
		Voice voice = builderService.VOICE()
				.addAudio("audio")
				.addSsml("ssml")
				.addText("text")
				.build();
		
		assertEquals(Voice.class, voice.getClass());
	}
	
	@Test
	public void dataModelShortText() {
		ShortText shortText = builderService.SHORT_TEXT()
				.addText("text")
				.build();
		
		assertEquals(ShortText.class, shortText.getClass());
	}

	@Test
	public void dataModelChoices() {
		Choices choices = builderService.CHOICES()
				.addImage("imageUrl")
				.addMatch("match")
				.addQuickReply(true)
				.addShortText(builderService.SHORT_TEXT().addText("text").build())
				.addText("text")
				.addUrl("url")
				.addValue("value")
				.addVoice(builderService.VOICE().addAudio("audio").addSsml("ssml").addText("text").build())
				.build();
		
		assertEquals(Choices.class, choices.getClass());
	}

	@Test
	public void dataModelCollect() {
		Collect collect = builderService.COLLECT()
				.addImage("imageUrl")
				.addMatch("match")
				.addQuickReply(true)
				.addShortText(builderService.SHORT_TEXT().addText("text").build())
				.addUrl("url")
				.addValue("value")
				.addVoice(builderService.VOICE().addAudio("audio").addSsml("ssml").addText("text").build())
				.build();
		
		assertEquals(Collect.class, collect.getClass());
	}
	
	@Test
	public void dataModelContent() {
		Content content = builderService.CONTENT()
				.addMatch("match")
				.addText("text")
				.addValue("value")				
				.build();
		
		assertEquals(Content.class, content.getClass());
	}
	
	@Test
	public void dataModelMenu() throws SdkExceptions {
		Menu menu = builderService.MENU()
				.addContent(builderService.CONTENT().addMatch("1").addText("text a").addValue("a").build())
				.addContent(builderService.CONTENT().addMatch("2").addText("text b").addValue("b").build())
				.addContent(builderService.CONTENT().addMatch("3").addText("text c").addValue("c").build())
				.addContent(builderService.CONTENT().addMatch("4").addText("text d").addValue("d").build())
				.addContent(builderService.CONTENT().addMatch("5").addText("text e").addValue("e").build())
				.addImage("imageUrl")
				.addInfo("info")
				.addTitle("title")
				.build();
		
		assertEquals(Menu.class, menu.getClass());
	}
	
	@Test
	public void requestTO() throws SdkExceptions {
		RequestTO request = Builder.REQUEST
				.addAction("action")
				.addCompany("company")
				.addPortfolio("portfolio")
				.addRequestId("requestId")
				.addToken("token")
				.build();
		
		assertEquals(RequestTO.class, request.getClass());
	}
	
	@Test
	public void responseErrorTO() throws SdkExceptions {
		ResponseTO response = Builder.RESPONSE
				.addCode("code")
				.addMessage("message")
				.addRequestId("requestId")
				.addStatus(false)
				.build();
		
		assertEquals(ResponseErrorTO.class, response.getClass());
	}
	
	@Test
	public void responseSuccessTO() throws SdkExceptions {
		ResponseTO response = Builder.RESPONSE
				.addCode("code")
				.addMessage("message")
				.addRequestId("requestId")
				.addStatus(true)
				.addResponse(KEY_EVENT_NAME, "event_name")
				.addResponse(KEY_STATUS, true)
				.build();
		
		assertEquals(ResponseSuccessTO.class, response.getClass());
	}
	
	@Test
	public void responseSuccessTOwithResponseFalse() throws SdkExceptions {
		ResponseTO response = Builder.RESPONSE
				.addCode("code")
				.addMessage("message")
				.addRequestId("requestId")
				.addStatus(true)
				.addResponse(KEY_EVENT_NAME, "event_name")
				.addResponse(KEY_STATUS, false)
				.addResponse(KEY_ERROR_CODE, "error_code")
				.addResponse(KEY_ERROR_MESSAGE, "error_message")
				.build();
		
		assertEquals(ResponseSuccessTO.class, response.getClass());
	}
	
	public void responseMethodExecute() throws SdkExceptions {
		RequestTO request = Builder.REQUEST
				.addAction("action")
				.addCompany("company")
				.addPortfolio("portfolio")
				.addRequestId("requestId")
				.addToken("token")
				.build();
		
		ResponseTO response = execute(request);
		
		assertEquals(ResponseTO.class, response.getClass());
	}

	@Override
	public ResponseTO execute(RequestTO requestTO) throws SdkExceptions {		
		ResponseTO to = Builder.RESPONSE
			.addStatus(true)
			.addRequestId(requestTO.getRequestId())
			.addResponse("response", builderService.SHORT_TEXT().addText("Olá eu sou o SDK do AVM").build())
			.addResponse(KEY_EVENT_NAME, requestTO.getAction())
			.addResponse(KEY_STATUS, false)
			//.addResponse(KEY_ERROR_CODE, "0001") 
			//.addResponse(KEY_ERROR_MESSAGE,"DEU RUIM") 
			.addCode("ERRO-001")				 
			.addMessage("Erro de integração")
			.build();			
		return to;
	}

}
