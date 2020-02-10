package br.com.cpqd.avm.sdk.v1.utils;

public interface SdkConstants {

	interface DataModel {

		public static final String LABEL = "datamodel";
		public static final String MENU = "MENU";
		public static final String CONTENT = "CONTENT";
		public static final String COLLECT = "COLLECT";
		public static final String VOICE = "VOICE";
		public static final String SHORT_TEXT = "SHORT_TEXT";
		public static final String CHOICES = "CHOICES";

	}

	interface Type {
		public static final String SIMPLE_MESSAGE = "SIMPLE_MESSAGE";
		public static final String COLLECT = "COLLECT";
		public static final String CHOICES = "CHOICES";
		public static final String MENU = "MENU";
		public static final String TRANSFER = "TRANSFER";
		public static final String FINALIZE_SERVICE = "FINALIZE_SERVICE";
		public static final String IGNORE = "IGNORE";
		public static final String UPLOAD = "UPLOAD";
	}

	interface RequestFields {
		public static final String REQUEST_ID = "requestId";
		public static final String COMPANY = "company";
		public static final String PORTFOLIO = "portfolio";
		public static final String TOKEN = "token";
		public static final String ACTION = "action";
	}

	interface ResponseFields {
		public static final String REQUEST_ID = "requestId";
		public static final String ACTION = "action";
		public static final String STATUS = "status";
		public static final String RESPONSE = "response";
		public static final String CODE = "code";
		public static final String MESSAGE = "message";

		interface Mandatory {
			public static final String EVENT_NAME = "eventName";
			public static final String STATUS = "status";
			public static final String ERROR_CODE = "errorCode";
			public static final String ERROR_MESSAGE = "errorMessage";
		}

	}

}
