package com.skills.process;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import okhttp3.*;

public class SkillFinder {
	/**
	 * 
	 * @return
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	private String Auth() throws JsonSyntaxException, IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse(ProcessConstants.ContentType);
		RequestBody body = RequestBody.create(mediaType, "client_id=" + ProcessConstants.ClientID + "&client_secret="
				+ ProcessConstants.Secret + "&grant_type=client_credentials&scope=" + ProcessConstants.Scope);
		Request request = new Request.Builder().url(ProcessConstants.AuthUrl).post(body)
				.addHeader("content-type",ProcessConstants.ContentType).build();

		Response response = client.newCall(request).execute();
		JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
		return jsonObject.get("access_token").getAsString();
	}
	
    /**
     * 
     * @param skill
     */
	public void find(String skill) {
		String authToken;
		try {
			authToken = Auth();
			fetchAndPrint(skill, authToken);
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param skill
	 * @param authtoken
	 * @throws IOException
	 */
	private void fetchAndPrint(String skill, String authtoken) throws IOException {
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
				.url(ProcessConstants.SkillfinderUrl+ skill + "%20progra").get()
				.addHeader("authorization", "Bearer " + authtoken).build();

		Response response = client.newCall(request).execute();
		System.out.println("Response: " + response.body().string());
	}
}
