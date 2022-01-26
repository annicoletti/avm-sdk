package br.com.cpqd.avm.sdk.v1.utils;

public interface SdkConstants {

	interface DataModel {
		String DATA_MODEL = "datamodel";
		String MENU = "MENU";
		String CONTENT = "CONTENT";
		String COLLECT = "COLLECT";
		String VOICE = "VOICE";
		String SHORT_TEXT = "SHORT_TEXT";
		String CHOICES = "CHOICES";

	}

	interface Type {
		String SIMPLE_MESSAGE = "SIMPLE_MESSAGE";
		String COLLECT = "COLLECT";
		String CHOICES = "CHOICES";
		String MENU = "MENU";
		String TRANSFER = "TRANSFER";
		String FINALIZE_SERVICE = "FINALIZE_SERVICE";
		String IGNORE = "IGNORE";
		String UPLOAD = "UPLOAD";
	}

	interface RequestFields {
		String REQUEST_ID = "requestId";
		String COMPANY = "company";
		String PORTFOLIO = "portfolio";
		String TOKEN = "token";
		String ACTION = "action";
		String PARAMETERS = "params";
	}

	interface ResponseFields {
		String REQUEST_ID = "requestId";
		String ACTION = "action";
		String STATUS = "status";
		String RESPONSE = "response";
		String CODE = "code";
		String MESSAGE = "message";
		
		String RESPONSE_TEMPLATE = "responseTemplate";

		interface Mandatory {
			String DATA_MODEL = "dataModel";
			String EVENT_NAME = "eventName";
			String TYPE = "type";
			String STATUS = "status";
			String ERROR_CODE = "errorCode";
			String ERROR_MESSAGE = "errorMessage";
		}

	}

}
