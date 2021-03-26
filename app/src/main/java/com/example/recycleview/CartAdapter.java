package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.model.Cat;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private List<Cat> cats ;
    private Context context ;

    public CartAdapter(List<Cat> cats, Context context) {
        this.cats = cats;
        this.context = context;
    }

    public CartAdapter(){

    }
    public void setData(List<Cat> list){
        this.cats = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        holder.img.setImageResource(cats.get(position).getImage());
        holder.name.setText(cats.get(position).getName());
        holder.price.setText(cats.get(position).getPrice());
        holder.subs.setText(cats.get(position).getSubs());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cats.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
       if(cats != null) {
           return cats.size();
       }
       return 0 ;
    }

    public Cat getItem(int position){
        return cats.get(position);
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView img  ;
        private TextView name,price,subs ;
        private Button remove  ;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.tv_name) ;
            price=itemView.findViewById(R.id.tv_price);
            subs=itemView.findViewById(R.id.tv_subs);
            remove=itemView.findViewById(R.id.remove);

        }
    }
}