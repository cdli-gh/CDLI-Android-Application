package cdlitablet.cdli.cdlisolutions.com.testing.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by
 * anandwana001 on
 * 08-03-2018 at
 * 09:36 AM.
 */

public class CdliData implements Parcelable {

  @SerializedName("date")
  private String date;
  @SerializedName("thumbnail-url")
  private String thumbnail_url;
  @SerializedName("url")
  private String url;
  @SerializedName("blurb-title")
  private String blurb_title;
  @SerializedName("theme")
  private String theme;
  @SerializedName("blurb")
  private String blurb;
  @SerializedName("full-title")
  private String full_title;
  @SerializedName("full-info")
  private String full_info;

  public CdliData() {
  }

  public CdliData(String date, String thumbnail_url, String url, String blurb_title,
      String theme, String blurb, String full_title, String full_info) {
    this.date = date;
    this.thumbnail_url = thumbnail_url;
    this.url = url;
    this.blurb_title = blurb_title;
    this.theme = theme;
    this.blurb = blurb;
    this.full_title = full_title;
    this.full_info = full_info;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getThumbnail_url() {
    return this.thumbnail_url;
  }

  public void setThumbnail_url(String thumbnail_url) {
    this.thumbnail_url = thumbnail_url;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getBlurb_title() {
    return this.blurb_title;
  }

  public void setBlurb_title(String blurb_title) {
    this.blurb_title = blurb_title;
  }

  public String getTheme() {
    return this.theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public String getBlurb() {
    return this.blurb;
  }

  public void setBlurb(String blurb) {
    this.blurb = blurb;
  }

  public String getFull_title() {
    return this.full_title;
  }

  public void setFull_title(String full_title) {
    this.full_title = full_title;
  }

  public String getFull_info() {
    return this.full_info;
  }

  public void setFull_info(String full_info) {
    this.full_info = full_info;
  }

  public static Parcelable.Creator<CdliData> getCREATOR() {
    return CdliData.CREATOR;
  }

  protected CdliData(Parcel in) {
    date = in.readString();
    thumbnail_url = in.readString();
    url = in.readString();
    blurb_title = in.readString();
    theme = in.readString();
    blurb = in.readString();
    full_title = in.readString();
    full_info = in.readString();
  }

  public static final Parcelable.Creator<CdliData> CREATOR = new Parcelable.Creator<CdliData>() {
    @Override
    public CdliData createFromParcel(Parcel in) {
      return new CdliData(in);
    }

    @Override
    public CdliData[] newArray(int size) {
      return new CdliData[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(date);
    dest.writeString(thumbnail_url);
    dest.writeString(url);
    dest.writeString(blurb_title);
    dest.writeString(theme);
    dest.writeString(blurb);
    dest.writeString(full_title);
    dest.writeString(full_info);
  }

  @Override
  public String toString() {
    return "CdliData{" +
        "date='" + date + '\'' +
        ", thumbnail_url='" + thumbnail_url + '\'' +
        ", url='" + url + '\'' +
        ", blurb_title='" + blurb_title + '\'' +
        ", theme='" + theme + '\'' +
        ", blurb='" + blurb + '\'' +
        ", full_title='" + full_title + '\'' +
        ", full_info='" + full_info + '\'' +
        '}';
  }
}
