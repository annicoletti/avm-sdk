package br.com.cpqd.avm.sdk.test;

import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Sample {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String json = null;

		json = sc.next();

		if (json != null) {
			Object object = new JSONTokener(json).nextValue();
			if (object instanceof JSONObject) {
				JSONObject jsonObject = new JSONObject(json);
				System.out.println(jsonObject.getBoolean("status"));
			} else {
				System.out.println("não é json");
			}
		}
		
		sc.close();

	}
}
