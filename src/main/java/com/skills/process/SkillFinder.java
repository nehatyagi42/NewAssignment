package com.skills.process;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import okhttp3.*;

public class SkillFinder {
	private String Auth() throws JsonSyntaxException, IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "client_id=" + ProcessConstants.ClientID + "&client_secret="
				+ ProcessConstants.Secret + "&grant_type=client_credentials&scope=" + ProcessConstants.Scope);
		Request request = new Request.Builder().url("https://auth.emsicloud.com/connect/token").post(body)
				.addHeader("content-type", "application/x-www-form-urlencoded").build();

		Response response = client.newCall(request).execute();
		JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
		return jsonObject.get("access_token").getAsString();
	}

	public void finder(String skill) throws JsonSyntaxException, IOException {

		String authToken = Auth();
		fetchAndPrint(skill, authToken);

	}

	private void fetchAndPrint(String skill, String authtoken) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://skills.emsicloud.com/versions/latest/skills?q=" + skill + "%20progra").get()
				.addHeader("authorization", "Bearer " + authtoken).build();

		Response response = client.newCall(request).execute();
		System.out.println("Response: " + response.body().string());
	}
}
