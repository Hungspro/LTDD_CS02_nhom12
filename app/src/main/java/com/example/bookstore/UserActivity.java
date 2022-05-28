package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstore.databinding.ActivityUserBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {
    private ActivityUserBinding binding;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        binding.btlogout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                checkUser();
            }
        });
    }
    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser==null)
        {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        else
        {
            String email = firebaseUser.getEmail();
            binding.tvsubTitle.setText(email);
        }
    }
}