package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MiViewHolder>{

       private Context context;
       private List <Prestaciones> Prestaciones;
       private RecyclerItemSelectedListener itemSelectedListener;

       public RecyclerAdapter(Context context, List<Prestaciones> prestaciones)
       {
           this.context =context;
           this.Prestaciones = prestaciones;
           this.itemSelectedListener= (MainActivity)context;

       }


        @NonNull
        @Override
        public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


           View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);


            return new MiViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {

           holder.ProfilePrestaciones.setText(Prestaciones.get(position).getPrestaciones());
            holder.ProfilePic.setImageDrawable(ContextCompat.getDrawable(context, Prestaciones.get(position).getPicId()));

        }

        @Override
        public int getItemCount() {
            return Prestaciones.size();
        }


        class MiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            CircleImageView ProfilePic;
            TextView ProfilePrestaciones;
            LinearLayout RootView;

            public MiViewHolder(@NonNull View itemView) {
                super(itemView);

                ProfilePrestaciones = itemView.findViewById(R.id.profile_name);
                ProfilePic = itemView.findViewById(R.id.profilePic);
                RootView = itemView.findViewById(R.id.rootView);
                RootView.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {

                itemSelectedListener.onItemSeled(Prestaciones.get(getAdapterPosition()));

            }
        }

        /*public void updatepList(List<Prestaciones> newPrestaciones)
        {
            Prestaciones.clear();
            Prestaciones.addAll(newPrestaciones);
            notifyDataSetChanged();
        }*/
    }
