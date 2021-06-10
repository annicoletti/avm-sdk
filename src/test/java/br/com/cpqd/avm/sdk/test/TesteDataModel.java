package br.com.cpqd.avm.sdk.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.com.cpqd.avm.sdk.v1.builder.impl.ResponseBuilder;
import br.com.cpqd.avm.sdk.v1.enums.EnumResponseSuccess;
import br.com.cpqd.avm.sdk.v1.enums.EnumType;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.Choices;
import br.com.cpqd.avm.sdk.v1.model.to.Collect;
import br.com.cpqd.avm.sdk.v1.model.to.Content;
import br.com.cpqd.avm.sdk.v1.model.to.Menu;
import br.com.cpqd.avm.sdk.v1.model.to.RequestAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmErrorTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseSuccessAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ShortText;
import br.com.cpqd.avm.sdk.v1.model.to.Voice;
import br.com.cpqd.avm.sdk.v1.service.api.Integration;

public class TesteDataModel implements Integration {
	
	@Test
	public void dataModelVoice() {
		Voice voice = DataModelBuilder.VOICE()
				.addAudio("audio")
				.addSsml("ssml")
				.addText("text")
				.build();
		
		assertEquals(Voice.class, voice.getClass());
	}
	
	@Test
	public void dataModelShortText() {
		ShortText shortText = DataModelBuilder.SHORT_TEXT()
				.addText("text")
				.build();
		
		assertEquals(ShortText.class, shortText.getClass());
	}

	@Test
	public void dataModelChoices() {
		Choices choices = DataModelBuilder.CHOICES()
				.addImage("imageUrl")
				.addMatch("match")
				.addQuickReply(true)
				.addShortText(DataModelBuilder.SHORT_TEXT().addText("text").build())
				.addText("text")
				.addUrl("url")
				.addValue("value")
				.addVoice(DataModelBuilder.VOICE().addAudio("audio").addSsml("ssml").addText("text").build())
				.build();
		
		assertEquals(Choices.class, choices.getClass());
	}

	@Test
	public void dataModelCollect() {
		Collect collect = DataModelBuilder.COLLECT()
				.addImage("imageUrl")
				.addMatch("match")
				.addQuickReply(true)
				.addShortText(DataModelBuilder.SHORT_TEXT().addText("text").build())
				.addUrl("url")
				.addValue("value")
				.addVoice(DataModelBuilder.VOICE().addAudio("audio").addSsml("ssml").addText("text").build())
				.build();
		
		assertEquals(Collect.class, collect.getClass());
	}
	
	@Test
	public void dataModelContent() {
		Content content = DataModelBuilder.CONTENT()
				.addMatch("match")
				.addText("text")
				.addValue("value")				
				.build();
		
		assertEquals(Content.class, content.getClass());
	}
	
	@Test
	public void dataModelMenu() throws SdkExceptions {
		Menu menu = DataModelBuilder.MENU()
				.addContent(DataModelBuilder.CONTENT().addMatch("1").addText("text a").addValue("a").build())
				.addContent(DataModelBuilder.CONTENT().addMatch("2").addText("text b").addValue("b").build())
				.addContent(DataModelBuilder.CONTENT().addMatch("3").addText("text c").addValue("c").build())
				.addContent(DataModelBuilder.CONTENT().addMatch("4").addText("text d").addValue("d").build())
				.addContent(DataModelBuilder.CONTENT().addMatch("5").addText("text e").addValue("e").build())
				.addImage("imageUrl")
				.addInfo("info")
				.addTitle("title")
				.build();
		
		assertEquals(Menu.class, menu.getClass());
	}
	
	@Test
	public void requestTO() throws SdkExceptions {
		RequestAvmTO request = ResponseBuilder.REQUEST
				.addAction("action")
				.addCompany("company")
				.addPortfolio("portfolio")
				.addRequestId("requestId")
				.addToken("token")
				.build();
		
		assertEquals(RequestAvmTO.class, request.getClass());
	}
	
	@Test
	public void responseErrorTO() throws SdkExceptions {
		ResponseAvmTO response = ResponseBuilder.RESPONSE_ERROR
				.addCode("code")
				.addMessage("message")
				.addRequestId(UUID.randomUUID().toString())
				.build();
		
		assertEquals(ResponseAvmErrorTO.class, response.getClass());
	}
	
	@Test
	public void responseSuccessTO() throws SdkExceptions {
		ResponseAvmTO response = ResponseBuilder.RESPONSE_SUCCESS
				.addRequestId(UUID.randomUUID().toString())
				.addDataModel(null)
				.addEventName("ACTION")
				.addType(EnumType.COLLECT)
				.addResponse(EnumResponseSuccess.STATUS, true)
				.build();
		
		assertEquals(ResponseSuccessAvmTO.class, response.getClass());
	}
	
	
	public void responseMethodExecute() throws SdkExceptions {
		RequestAvmTO request = ResponseBuilder.REQUEST
				.addAction("action")
				.addCompany("company")
				.addPortfolio("portfolio")
				.addRequestId("requestId")
				.addToken("token")
				.build();
		
		ResponseAvmTO response = execute(request);
		
		assertEquals(ResponseAvmTO.class, response.getClass());
	}

	@Override
	public ResponseAvmTO execute(RequestAvmTO requestTO) throws SdkExceptions {		
		ResponseAvmTO to = ResponseBuilder.RESPONSE_ERROR
			.addRequestId(requestTO)
			.addMessage("message")
			.build();			
		return to;
	}

}
