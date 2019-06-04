package in.aroliant.expandablerecyclerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aroliant on 1/3/2018.
 */

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<String> image = new ArrayList<String>();
    ArrayList<Integer> counter = new ArrayList<Integer>();
    ArrayList<ArrayList> itemNameList = new ArrayList<ArrayList>();
    Context context;

    public ExpandableRecyclerViewAdapter(Context context,
                                         ArrayList<String> nameList,
                                         ArrayList<ArrayList> itemNameList) {
        this.nameList = nameList;
        this.itemNameList = itemNameList;
        this.context = context;


        for (int i = 0; i < nameList.size(); i++) {
            counter.add(0);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageButton dropBtn;
        RecyclerView cardRecyclerView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.categoryTitle);
            dropBtn = itemView.findViewById(R.id.categoryExpandBtn);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_collapseview, parent, false);

        ExpandableRecyclerViewAdapter.ViewHolder vh = new ExpandableRecyclerViewAdapter.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(nameList.get(position));

        InnerRecyclerViewAdapter itemInnerRecyclerView = new InnerRecyclerViewAdapter(itemNameList.get(position));


        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter.get(position) % 2 == 0) {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);


            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView);

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}
