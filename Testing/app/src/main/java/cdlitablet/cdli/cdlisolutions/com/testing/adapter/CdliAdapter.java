package cdlitablet.cdli.cdlisolutions.com.testing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cdlitablet.cdli.cdlisolutions.com.testing.R;
import cdlitablet.cdli.cdlisolutions.com.testing.adapter.CdliAdapter.MyViewHolder;
import cdlitablet.cdli.cdlisolutions.com.testing.model.CdliData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.List;

/**
 * Created by
 * anandwana001 on
 * 08-03-2018 at
 * 10:41 AM.
 */

public class CdliAdapter extends Adapter<MyViewHolder> {

  private List<CdliData> cdliDataList;
  private Context mContext;

  public CdliAdapter(List<CdliData> cdliDataList, Context mContext) {
    this.cdliDataList = cdliDataList;
    this.mContext = mContext;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_cdli, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    final CdliData cdliData = cdliDataList.get(position);

    holder.title.setText(cdliData.getBlurb_title());

    Glide.with(mContext).load(cdliData.getThumbnail_url())
        .thumbnail(0.5f)
        .crossFade()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(holder.thumbnail);
  }

  @Override
  public int getItemCount() {
    return cdliDataList.size();
  }

  public class MyViewHolder extends ViewHolder {

    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.title)
    TextView title;

    public MyViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
