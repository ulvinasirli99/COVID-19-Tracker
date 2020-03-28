package game.devloper.covid19statistics.Helper;

import com.google.gson.annotations.SerializedName;

public class KabinetInfo{


	@SerializedName("body")
	private String body;

	@SerializedName("title")
	private String title;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
