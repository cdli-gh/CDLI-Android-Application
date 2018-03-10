package cdlitablet.cdli.cdlisolutions.com.testing.network;

import cdlitablet.cdli.cdlisolutions.com.testing.model.CdliData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by
 * anandwana001 on
 * 08-03-2018 at
 * 09:35 AM.
 */

public interface CdliInterface {

  @GET("fetchdata.php")
  Call<List<CdliData>> getLake();
}
