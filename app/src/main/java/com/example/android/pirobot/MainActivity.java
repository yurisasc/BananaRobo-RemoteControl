package com.example.android.pirobot;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button btn_left, btn_forward, btn_backward, btn_right, btn_stop;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference commandRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        firebaseDatabase = FirebaseDatabase.getInstance();
        commandRef = firebaseDatabase.getReference().child("command");
    }

    private void init() {
        btn_left = findViewById(R.id.btn_left);
        btn_forward = findViewById(R.id.btn_forward);
        btn_right = findViewById(R.id.btn_right);
        btn_backward = findViewById(R.id.btn_backward);
        btn_stop = findViewById(R.id.btn_stop);

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        commandRef.child("node").setValue("left");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });

        btn_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        commandRef.child("node").setValue("forward");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        commandRef.child("node").setValue("right");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });

        btn_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        commandRef.child("node").setValue("backward");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        commandRef.child("node").setValue("stop");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
