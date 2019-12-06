package com.mple.matei.glumebune;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;



/**
 * Created by Matei on 12/2/2017.
 */


public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder>{

    private List<Postache> mPostList;
    Context ctx;

    public FavAdapter(List<Postache> mPostList, Context ctx){
        this.mPostList = mPostList;
        this.ctx=ctx;

    }

    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gluma_layout,parent,false);



        return new FavViewHolder(v,ctx);
    }


    public class FavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView postTitle;
        public TextView gluma;
        public TextView postName;
        public TextView postDate;
        public TextView score;

        public String postId;
        public String glumas;
        public String city;
        public DatabaseReference mFavs;
        public FirebaseAuth mAuth;
        public String current_user;

        Context ctx;
        public FavViewHolder(View itemView,Context ctx) {
            super(itemView);
            this.ctx=ctx;
            itemView.setOnClickListener(this);
            postTitle=(TextView)itemView.findViewById(R.id.post_title);
            gluma=(TextView)itemView.findViewById(R.id.post_desc);
            postName=(TextView)itemView.findViewById(R.id.post_name);
            postDate=(TextView)itemView.findViewById(R.id.post_date);

            score=(TextView)itemView.findViewById(R.id.score_post);

        }


        @Override
        public void onClick(View view) {

            CharSequence options[] = new  CharSequence[]{"Sterge din favorite", "Trimite-o mai departe"};
            AlertDialog.Builder builder =new AlertDialog.Builder(ctx);
            builder.setTitle(city);
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    if(i== 0){
                        mFavs.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(ctx, "Gluma a fost stearsa!", Toast.LENGTH_LONG).show();
                            }
                        });
                        dialogInterface.dismiss();


                    }
                    if(i ==1){
                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String shareBody = glumas;
                        String shareSub = glumas + "     -----> Mai multe glume bune la https://play.google.com/store/apps/details?id=com.mple.matei.glumebune ";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                        myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                        ctx.startActivity(Intent.createChooser(myIntent, "Share using"));

                    }


                }
            });
            builder.show();
        }
    }





    @Override
    public void onBindViewHolder(FavAdapter.FavViewHolder holder, int position) {

        Postache c = mPostList.get(position);


        holder.mAuth=FirebaseAuth.getInstance();
        holder.current_user=holder.mAuth.getCurrentUser().getUid().toString();
        holder.glumas=c.getGluma();
        holder.city=c.getTitlu();
        holder.postId=c.getId();
        holder.score.setText(" ");
        holder.gluma.setText(c.getGluma());
        holder.postDate.setText(c.getDate());
        holder.postName.setText(c.getName());
        holder.postTitle.setText(c.getTitlu());
        holder.mFavs= FirebaseDatabase.getInstance().getReference().child("Favorite").child(holder.current_user).child(c.getId());




    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}















