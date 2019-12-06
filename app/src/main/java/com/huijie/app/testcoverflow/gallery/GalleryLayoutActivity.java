package com.huijie.app.testcoverflow.gallery;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.huijie.app.testcoverflow.DataAdapter;
import com.huijie.app.testcoverflow.R;
import com.huijie.app.testcoverflow.Util;
import com.huijie.app.testcoverflow.test.GalleryLayoutManager;
import com.huijie.app.testcoverflow.test.ScrollHelper;

/**
 *
 * @author Dajavu
 * @date 27/10/2017
 */

public class GalleryLayoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        recyclerView = findViewById(R.id.recycler);
        DataAdapter dataAdapter = new DataAdapter();
        dataAdapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(v.getContext(), "clicked:" + pos, Toast.LENGTH_SHORT).show();
                ScrollHelper.smoothScrollToTargetView(recyclerView, v);
            }
        });
        GalleryLayoutManager galleryLayoutManager = new GalleryLayoutManager(this, Util.Dp2px(this, 10));
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(galleryLayoutManager);
    }
}
