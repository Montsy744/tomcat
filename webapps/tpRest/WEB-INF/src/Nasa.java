import com.fasterxml.jackson.annotation.JsonProperty;

public class Nasa {
	public String copyright;
	public String date;
	public String explanation;
	public String hdurl;
    @JsonProperty("media_type")
	public String mediaType;
    @JsonProperty("service_version")
	public String serviceVersion;
	public String title;
	public String url;

	public String getCopyright() {
		return this.copyright;
	}

	public String getDate() {
		return this.date;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public String getHdurl() {
		return this.hdurl;
	}

	public String getMediaType() {
		return this.mediaType;
	}

	public String getServiceVersion() {
		return this.serviceVersion;
	}

	public String getTitle() {
		return this.title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setHdurl(String hdurl) {
		this.hdurl = hdurl;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		System.out.println("appel");
		return "Nasa : " + this.getTitle() + "\n" + this.getDate() + "\n" + this.getCopyright() + "\n" + this.getExplanation() + "\n" + this.getMediaType() + "\n" + this.getServiceVersion();
	}
}

