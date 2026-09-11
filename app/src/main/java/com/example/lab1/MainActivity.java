package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button tvBtn;
    private ImageButton imgBtn;
    private TextView nameText;
    private TextView groupText;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvBtn = findViewById(R.id.btnTV);
        imgBtn = findViewById(R.id.imgBtn);
        nameText = findViewById(R.id.tvName);
        groupText = findViewById(R.id.tvGroup);
        img = findViewById(R.id.imageView);

        tvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldVisibility = nameText.getVisibility();
                int newVisibility = oldVisibility == View.VISIBLE ? View.INVISIBLE : View.VISIBLE;

                nameText.setVisibility(newVisibility);
                groupText.setVisibility(newVisibility);
            }
        });

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldVisibility = img.getVisibility();
                int newVisibility = oldVisibility == View.VISIBLE ? View.INVISIBLE : View.VISIBLE;

                img.setVisibility(newVisibility);
            }
        });
    }
}