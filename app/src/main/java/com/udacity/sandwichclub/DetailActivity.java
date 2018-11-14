package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);
        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {

        /* Borrowed from: https://stackoverflow.com/questions/15636401/how-to-set-margins-for-textview-programmatically */
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(40,10,10,10);

        TextView  textView;

        textView = findViewById(R.id.also_known_label_tv);
        textView.setPadding(30,10,0,10);

        textView = findViewById(R.id.also_known_tv);
        textView.setText(sandwich.getAlsoKnownAsString());
        textView.setLayoutParams(params);


        textView = findViewById(R.id.ingredient_label_tv);
        textView.setPadding(30,10,0,10);

        textView = findViewById((R.id.ingredients_tv));
        textView.setText(sandwich.getIngredientsString());
        textView.setLayoutParams(params);

        textView = findViewById(R.id.place_label_tv);
        textView.setPadding(30,10,0,10);

        textView = findViewById((R.id.place_of_origin_tv));
        textView.setText(sandwich.getPlaceOfOrigin());
        textView.setLayoutParams(params);

        textView = findViewById(R.id.detail_desc_label_tv);
        textView.setPadding(30,10,0,10);

        textView = findViewById(R.id.description_tv);
        textView.setText(sandwich.getDescription());
        textView.setLayoutParams(params);
    }
}
