package cdlitablet.cdli.cdlisolutions.com.testing.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cdlitablet.cdli.cdlisolutions.com.testing.R;
import cdlitablet.cdli.cdlisolutions.com.testing.adapter.CdliAdapter;
import cdlitablet.cdli.cdlisolutions.com.testing.model.CdliData;
import cdlitablet.cdli.cdlisolutions.com.testing.network.CdliClient;
import cdlitablet.cdli.cdlisolutions.com.testing.network.CdliInterface;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;
  @BindView(R.id.no_fav)
  TextView noFav;
  private List<CdliData> cdliData;

  private CdliAdapter cdliAdapter;
  private Parcelable mListState;
  private GridLayoutManager mLayoutManager;
  private String LIST_STATE_KEY = "list_state";

  private ConnectivityManager connectivityManager;
  private NetworkInfo isConnectedOrConnecting;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    cdliData = new ArrayList<>();
    cdliAdapter = new CdliAdapter(cdliData,this);
    mLayoutManager = new GridLayoutManager(this, 2);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setAdapter(cdliAdapter);

    connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    isConnectedOrConnecting = connectivityManager.getActiveNetworkInfo();

    if (isConnectedOrConnecting != null && isConnectedOrConnecting.isConnectedOrConnecting()) {
      getData();
    } else {
      noFav.setVisibility(View.VISIBLE);
      noFav.setText(getString(R.string.no_internet));
    }

    if (isConnectedOrConnecting != null && isConnectedOrConnecting.isConnectedOrConnecting()) {
      if (savedInstanceState != null)
        mListState = savedInstanceState.getParcelable(LIST_STATE_KEY);
      else
        getData();
    } else {
      noFav.setVisibility(View.VISIBLE);
      noFav.setText(getString(R.string.no_internet));
    }
  }

  private void getData(){
    CdliInterface sensorInterface = CdliClient.getClient().create(CdliInterface.class);
    Call<List<CdliData>> call = sensorInterface.getLake();
    call.enqueue(new Callback<List<CdliData>>() {
      @Override
      public void onResponse(Call<List<CdliData>> call, Response<List<CdliData>> response) {
        cdliData = response.body();
        cdliAdapter = new CdliAdapter(cdliData,MainActivity.this);
        recyclerView.setAdapter(cdliAdapter);
        mLayoutManager.onRestoreInstanceState(mListState);
      }

      @Override
      public void onFailure(Call<List<CdliData>> call, Throwable t) {
        noFav.setVisibility(View.VISIBLE);
        noFav.setText(getString(R.string.no_internet));
      }
    });
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mListState = mLayoutManager.onSaveInstanceState();
    outState.putParcelable(LIST_STATE_KEY, mListState);
  }

  @Override
  public void onResume() {
    super.onResume();
    if (mListState != null) {
      mLayoutManager.onRestoreInstanceState(mListState);
    }
  }
}
