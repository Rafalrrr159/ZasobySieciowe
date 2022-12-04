package com.example.zasobysieciowe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK_DETAILS_TITLE = "com.example.BOOK_DETAILS_TITLE";
    public static final String EXTRA_BOOK_DETAILS_AUTHOR = "com.example.BOOK_DETAILS_AUTHOR";
    public static final String EXTRA_BOOK_DETAILS_PAGES = "com.example.BOOK_DETAILS_PAGES";
    public static final String EXTRA_BOOK_DETAILS_COVER_ID = "com.example.BOOK_DETAILS_COVER_ID";
    private TextView titleTextView;
    private TextView authorTextView;
    private TextView numberOfPagesTextView;
    private ImageView cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_details);

        titleTextView = findViewById(R.id.book_title);
        authorTextView = findViewById(R.id.book_author);
        numberOfPagesTextView = findViewById(R.id.number_of_pages);
        cover = findViewById(R.id.img_cover);

        Intent starter = getIntent();
        titleTextView.setText(starter.getStringExtra(EXTRA_BOOK_DETAILS_TITLE));
        authorTextView.setText(starter.getStringExtra(EXTRA_BOOK_DETAILS_AUTHOR));
        numberOfPagesTextView.setText(starter.getStringExtra(EXTRA_BOOK_DETAILS_PAGES));
        String coverId = starter.getStringExtra(EXTRA_BOOK_DETAILS_COVER_ID);
        if (coverId != null)
            Picasso.with(this)
                    .load(MainActivity.IMAGE_URL_BASE + coverId + "-L.jpg")
                    .placeholder(R.drawable.ic_baseline_book_24)
                    .into(cover);
        else
            cover.setImageResource(R.drawable.ic_baseline_book_24);
    }
}