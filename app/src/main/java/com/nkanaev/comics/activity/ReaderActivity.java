package com.nkanaev.comics.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import com.nkanaev.comics.R;
import com.nkanaev.comics.fragment.ReaderFragment;
import com.squareup.picasso.Picasso;


public class ReaderActivity extends ActionBarActivity {
    public static final String PARAM_COMIC_ID = "PARAM_COMIC_ID";

    private Picasso mPicasso;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_reader);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            int comicId = extras.getInt(PARAM_COMIC_ID);

            ReaderFragment fragment = ReaderFragment.create(comicId);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame_reader, fragment)
                    .commit();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}