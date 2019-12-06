package com.mple.matei.glumebune;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by Matei on 11/30/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Postache> mPostList;
    Context ctx;

    public PostAdapter(List<Postache> mPostList, Context ctx) {
        this.mPostList = mPostList;
        this.ctx = ctx;

    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gluma_layout, parent, false);


        return new PostViewHolder(v, ctx);
    }


    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titlu;
        public TextView gluma;
        public TextView nume;
        public TextView date;
        public TextView scor;
        public DatabaseReference mFavData;
        public DatabaseReference mPost;
        public String titluNume;
        public DatabaseReference mCat;

        public FirebaseAuth mAuth;
        public String current_user;
        public DatabaseReference mState;
        public String idd;
        public String glumas;
        public String nnume;




        Context ctx;

        public PostViewHolder(View itemView, Context ctx) {
            super(itemView);
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            titlu = (TextView) itemView.findViewById(R.id.post_title);
            gluma = (TextView) itemView.findViewById(R.id.post_desc);
            nume = (TextView) itemView.findViewById(R.id.post_name);
            date = (TextView) itemView.findViewById(R.id.post_date);
            scor = (TextView) itemView.findViewById(R.id.score_post);



        }


        @Override
        public void onClick(View view) {

            CharSequence options[] = new  CharSequence[]{"Adauga la favorite", "Trimite-o mai departe","Raporteaza ca spam"};
            final AlertDialog.Builder builder =new AlertDialog.Builder(ctx);
            final String currentDate = DateFormat.getDateTimeInstance().format(new Date());
            builder.setTitle(titluNume);
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(final DialogInterface dialogInterface, int i) {
                    final Map map = new HashMap();
                    map.put("titlu", titluNume);
                    map.put("gluma", glumas);
                    map.put("name", nnume);
                    map.put("id", idd);
                    map.put("timp",10000000-System.currentTimeMillis());
                    map.put("user_id", current_user);
                    map.put("date",currentDate);
                    if(i== 0){
                       mFavData.child(current_user).child(idd).updateChildren(map, new DatabaseReference.CompletionListener() {
                           @Override
                           public void onComplete(final DatabaseError databaseError, DatabaseReference databaseReference) {
                               dialogInterface.dismiss();
                               mPost.addListenerForSingleValueEvent(new ValueEventListener() {
                                   @Override
                                   public void onDataChange(DataSnapshot dataSnapshot) {
                                       int a = dataSnapshot.child("real").getValue(Integer.class);
                                       a++;
                                       int b = dataSnapshot.child("score").getValue(Integer.class);
                                       b=b-a;
                                       mPost.child("real").setValue(a);
                                       mPost.child("score").setValue(b);
                                       mCat.child("real").setValue(a);
                                       mCat.child("score").setValue(b);

                                   }

                                   @Override
                                   public void onCancelled(DatabaseError databaseError) {

                                   }
                               });
                               Toast.makeText(ctx, "Gluma salvata la favorite", Toast.LENGTH_LONG).show();
                           }
                       });
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
                    if(i ==2){

                        mState.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(!dataSnapshot.hasChild(current_user)){

                                    mPost.child("spam").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            int a =dataSnapshot.getValue(Integer.class);
                                            a++;
                                            if(a==20){
                                                mPost.removeValue();
                                                mCat.removeValue();
                                                dialogInterface.dismiss();

                                                Toast.makeText(ctx, "Multumim pentru ajutor!", Toast.LENGTH_LONG).show();
                                            }else if(a<20){
                                                mPost.child("score").addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        int q= dataSnapshot.getValue(Integer.class);
                                                       q= q+7;
                                                       mPost.child("score").setValue(q);
                                                    }
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {
                                                    }
                                                });
                                                mPost.child("timp").addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        long q= dataSnapshot.getValue(long.class);
                                                        q= q+1000000;
                                                        mPost.child("timp").setValue(q);
                                                    }
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {
                                                    }
                                                });
                                                mPost.child("spam").setValue(a);
                                                mCat.child("spam").setValue(a);
                                            }
                                            mState.child(current_user).setValue("yaaas");

                                            Toast.makeText(ctx, "Multumim pentru ajutor!", Toast.LENGTH_LONG).show();
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });
                                }else{
                                    dialogInterface.dismiss();
                                    Toast.makeText(ctx, "Gluma a fost raportata deja", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }


                }
            });
            builder.show();

        }
    }



    @Override
    public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {

        Postache c = mPostList.get(position);


        holder.mCat=FirebaseDatabase.getInstance().getReference().child("categorii").child(c.getCategorie()).child(c.getId());
        holder.glumas=c.getGluma();
        holder.nnume=c.getName();
        holder.idd=c.getId();
        holder.mAuth=FirebaseAuth.getInstance();
        holder.current_user=holder.mAuth.getCurrentUser().getUid().toString();
        holder.mFavData=FirebaseDatabase.getInstance().getReference().child("Favorite");
        holder.mPost=FirebaseDatabase.getInstance().getReference().child("Glume").child(c.getId());
        holder.mState=FirebaseDatabase.getInstance().getReference().child("spamState").child(c.getId());
        holder.titluNume= c.getTitlu();
        holder.titlu.setText(c.getTitlu());
        holder.date.setText(c.getDate());
        holder.nume.setText(c.getName());
        holder.gluma.setText(c.getGluma());
        holder.scor.setText(c.getReal() + " ✰");


    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}

