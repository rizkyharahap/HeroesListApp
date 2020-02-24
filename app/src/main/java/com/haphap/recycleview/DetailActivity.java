package com.haphap.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    ImageView ivPhoto;
    TextView tvName, tvDescription;

    Hero heroes = new Hero();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhoto = findViewById(R.id.iv_photo);
        tvName = findViewById(R.id.tv_name);
        tvDescription = findViewById(R.id.tv_description);

        heroes = Objects.requireNonNull(getIntent().getExtras()).getParcelable("Data");

        assert heroes != null;
        tvName.setText(heroes.getName());
        tvDescription.setText(heroes.getDetail());
        Glide.with(getApplicationContext())
                .load(heroes.getPhoto())
                .apply(new RequestOptions().override(200,200))
                .into(ivPhoto);
    }
}
