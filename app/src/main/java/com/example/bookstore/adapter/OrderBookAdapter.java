package com.example.bookstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstore.R;
import com.example.bookstore.model.Book;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class OrderBookAdapter extends RecyclerView.Adapter<OrderBookAdapter.orderbookviewholder> {
    Context context;
    List<String> listIdBook;

    public OrderBookAdapter(Context context, List<String> listIdBook) {
        this.context = context;
        this.listIdBook = listIdBook;
    }

    @NonNull
    @Override
    public orderbookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.apdapter_book_order,parent,false);
        return new orderbookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderbookviewholder holder, int position) {
        System.out.println(listIdBook.get(position));
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Books").child(listIdBook.get(position));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Book book=snapshot.getValue(Book.class);
                    holder.nameBook.setText(book.getName());

                    Glide.with(context).load(book.getImage()).into(holder.imageBook);
                    holder.priceBook.setText(String.valueOf(book.getPrice()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    @Override
    public int getItemCount() {
        return listIdBook.size();
    }

    public class orderbookviewholder extends RecyclerView.ViewHolder{

        private ConstraintLayout layoutItem;
        ImageView imageBook;
        TextView nameBook,priceBook;

        public orderbookviewholder(@NonNull View itemView) {
            super(itemView);
            imageBook= itemView.findViewById(R.id.imageBook);
            nameBook=itemView.findViewById(R.id.nameBook);
            priceBook=itemView.findViewById(R.id.priceBook);
        }
    }
}
