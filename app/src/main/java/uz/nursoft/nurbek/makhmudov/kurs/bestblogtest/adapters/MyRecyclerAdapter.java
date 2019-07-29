package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.R;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.models.ModelRecycler;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<ModelRecycler> modelRecyclers;

    public MyRecyclerAdapter(Context context, List<ModelRecycler> modelRecyclers) {
        this.context = context;
        this.modelRecyclers = modelRecyclers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d("MyTag", getClass().getName() + " >> onBindViewHolder: position = " + position);

        ModelRecycler modelRecycler = modelRecyclers.get(position);

        holder.itemTitleTv.setText(modelRecycler.getTitle());
        holder.itemDescTv.setText(modelRecycler.getDesc());
        holder.itemLikeTv.setText(modelRecycler.getLike());
        holder.itemCommentTv.setText(modelRecycler.getComment());
        holder.itemSeeTv.setText(modelRecycler.getSee());
        holder.itemTimeTv.setText(modelRecycler.getTime());

        holder.itemRecyclerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelRecyclers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemTitleTv, itemDescTv, itemLikeTv, itemCommentTv, itemSeeTv, itemTimeTv;
        CardView itemRecyclerCardView;

        public ViewHolder(View itemView) {
            super(itemView);

            itemTitleTv  = (TextView)itemView.findViewById(R.id.itemTitleTv);
            itemDescTv  = (TextView)itemView.findViewById(R.id.itemDescTv);
            itemLikeTv  = (TextView)itemView.findViewById(R.id.itemLikeTv);
            itemCommentTv  = (TextView)itemView.findViewById(R.id.itemCommentTv);
            itemSeeTv  = (TextView)itemView.findViewById(R.id.itemSeeTv);
            itemTimeTv  = (TextView)itemView.findViewById(R.id.itemTimeTv);

            itemRecyclerCardView  = (CardView) itemView.findViewById(R.id.itemRecyclerCardView);
        }
    }

}
