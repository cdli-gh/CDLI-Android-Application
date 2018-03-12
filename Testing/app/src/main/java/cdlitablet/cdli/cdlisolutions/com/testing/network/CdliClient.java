package cdlitablet.cdli.cdlisolutions.com.testing.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by
 * anandwana001 on
 * 08-03-2018 at
 * 09:35 AM.
 */

public class CdliClient {

  private static final String BASE_URL = "http://cdli.ucla.edu/cdlitablet_android/";
  private static Retrofit retrofit = null;

  public static Retrofit getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
