package pe.com.patadeperro.presentation.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.com.patadeperro.R;
import pe.com.patadeperro.domain.model.Place;
import pe.com.patadeperro.presentation.ui.activities.MapActivity;

import java.util.ArrayList;

public class MapHorizontalListDataAdapter extends RecyclerView.Adapter<MapHorizontalListDataAdapter.SingleItemRowHolder> {


    private ArrayList<Place> itemsList;
    private Context mContext;

    public MapHorizontalListDataAdapter(Context context, ArrayList<Place> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail_map, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        Place place = itemsList.get(i);

        holder.tvTitle.setText(place.getName());


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            //   this.itemImage = (ImageView) view.findViewById(R.id.itemImage);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent= new Intent(mContext, MapActivity.class);
                    mContext.startActivity(intent);

                    // Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}