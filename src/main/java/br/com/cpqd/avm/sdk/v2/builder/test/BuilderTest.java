package br.com.cpqd.avm.sdk.v2.builder.test;

import org.json.JSONObject;

import br.com.cpqd.avm.sdk.v2.builder.api.AvmDataModel;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmChoicesTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmCollectTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmContentTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmItensChoicesTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmItensMenuTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmMenuTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmShortTextTO;
import br.com.cpqd.avm.sdk.v2.model.to.datamodel.AvmVoiceTO;

public class BuilderTest {

	public static void main(String[] args) {

		exampleMenu();
		exampleChoice();
		exampleCollect();
		
		AvmDataModel menu = new AvmMenuTO.Builder().build();
		System.out.println(menu.getType());
		
	}

	private static void exampleCollect() {
		AvmCollectTO collect = new AvmCollectTO.Builder()
				.addImageUrl("uma imagem")
				.addMatch("match ???")
				.addQuick_reply(Boolean.TRUE)
				.addShort_text(new AvmShortTextTO.Builder().addText("short").build())
				.addText("teeeeeeeeexto")
				.addUrl("URL")
				.addValue("um valor")
				.addVoice(new AvmVoiceTO.Builder()
						.addAudio("um audio")
						.addSsml("sssssml")
						.addText("text")
						.build())
				.build();
		

		System.out.println("[Collect] - " + new JSONObject(collect).toString(4));
	}

	private static void exampleChoice() {
		AvmItensChoicesTO choices = new AvmItensChoicesTO.Builder()
				.addImageUrl("image url")
				.addMatch("um match")
				.addQuick_reply(Boolean.FALSE)
				.addShort_text(new AvmShortTextTO.Builder().addText("short text").build())
				.addText("um texto")
				.addUrl("urllll")
				.addValue("é o valor")
				.addVoice(new AvmVoiceTO.Builder()
						.addAudio("audio tag")
						.addSsml("ssml")
						.addText("texto")
						.build())
				.build();
		
		AvmChoicesTO choice = new AvmChoicesTO.Builder()
				.addChoices(choices)
				.addChoices(choices)
				.addChoices(choices)
				.addChoices(choices)
				.build();
		
		System.out.println("[collect] - " + new JSONObject(choice).toString(4));
	}

	private static void exampleMenu() {
		AvmContentTO content = new AvmContentTO.Builder()
				.addMatch("bla")
				.addText("text")
				.addValue("value")
				.build();

		AvmItensMenuTO itemMenu = new AvmItensMenuTO.Builder()
				.addImageUrl("imagem url")
				.addInfo("alguma info")
				.addTitle("Titulo")
				.addContent(new AvmContentTO.Builder()
						.addMatch("um match")
						.addText("o texto")
						.addValue("é o valooor")
						.build())
				.addContent(content)
				.build();
		
		AvmMenuTO menu = new AvmMenuTO.Builder()
				.addItensMenu(itemMenu)
				.addItensMenu(itemMenu)
				.addItensMenu(itemMenu)
				.addItensMenu(itemMenu)
				.addItensMenu(new AvmItensMenuTO.Builder()
						.addContent(new AvmContentTO.Builder()
								.addMatch("aaaaaaaaaaa")
								.addText("ttttttttttt")
								.addValue("vvvvvvvvvvvv")
								.build())
						.addImageUrl("uuuuuuuu")
						.addInfo("iiiiiiiiiii")
						.addTitle("tttttttttttt")
						.build())
				.build();

		System.out.println("[MENU] - " + new JSONObject(menu).toString(4));
	}
}
