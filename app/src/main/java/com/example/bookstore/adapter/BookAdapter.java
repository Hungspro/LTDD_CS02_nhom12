package com.example.bookstore.adapter;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstore.BookDetailsActivity;
import com.example.bookstore.R;
import com.example.bookstore.model.Book;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {
     Context context;
    List<String> listIdBook;

    public BookAdapter(Context context,List<String> listIdBook){
        this.context = context;
        this.listIdBook = listIdBook;
    }

    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_grid,parent,false);
        return new bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewholder holder, int position) {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Books").child(listIdBook.get(position));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Book book=snapshot.getValue(Book.class);
                holder.name.setText(book.getName());

                Glide.with(context).load(book.getImage()).into(holder.imgBook);
                holder.layoutItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickGoToDetail(snapshot.getKey());
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void onClickGoToDetail(String idBook){
        Intent intent = new Intent(context, BookDetailsActivity.class);

        intent.putExtra("idBook",idBook);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return listIdBook.size();
    }

    public class bookviewholder extends RecyclerView.ViewHolder{

        private ConstraintLayout layoutItem;
        ImageView imgBook;
        TextView name;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.book_layout);
            imgBook = itemView.findViewById(R.id.book_image);
            name = itemView.findViewById(R.id.book_name);
        }
    }

}
