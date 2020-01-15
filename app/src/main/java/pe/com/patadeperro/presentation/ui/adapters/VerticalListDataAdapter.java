package pe.com.patadeperro.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.com.patadeperro.R;
import pe.com.patadeperro.domain.model.Place;

import java.util.ArrayList;
import java.util.List;

public class VerticalListDataAdapter extends RecyclerView.Adapter<VerticalListDataAdapter.ViewHolderPlace> {


    private List<Place> items = new ArrayList<>();

    public OnItemClickListener mlistener;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClicked(View v, Place category);
    }

    public void add(Place item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }


    @Override
    public ViewHolderPlace onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_list, parent, false);
        ViewHolderPlace rvMainAdapterViewHolder = new ViewHolderPlace(view);

        return rvMainAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPlace holder, int position) {
        Place place = items.get(position);

        holder.tvTitle.setText(place.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolderPlace extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView tvTitle;

        public ViewHolderPlace(View v) {
            super(v);
            this.tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        //    Intent intent= new Intent(mContext, DetailPlaceActivity.class);
        //    mContext.startActivity(intent);


            Place place = new Place("", "");
            mlistener.onItemClicked(v, place);
        }
    }


    public VerticalListDataAdapter(OnItemClickListener listener, Context context, ArrayList<Place> item) {
        this.items = item;
        this.mlistener = listener;
        this.mContext = context;
    }


}


