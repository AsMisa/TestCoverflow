package com.huijie.app.testcoverflow.recyercoverflow;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huijie.app.testcoverflow.R;
import com.huijie.app.testcoverflow.recyercoverflow.coverflow.CoverFlowLayoutManger;
import com.huijie.app.testcoverflow.recyercoverflow.coverflow.RecyclerCoverFlow;

public class JustCoverFlowActivity extends AppCompatActivity implements Adapter.onItemClick {

    private RecyclerCoverFlow mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_coverflow);
        initList();
    }

    private void initList() {
        mList = findViewById(R.id.list);
        mList.setFlatFlow(false); //平面滚动
        mList.setIntervalRatio(0.8f);
//        mList.setGreyItem(true); //设置灰度渐变
//        mList.setAlphaItem(true); //设置半透渐变
        mList.setAdapter(new Adapter(this, this));
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }

    @Override
    public void clickItem(int pos) {
        mList.smoothScrollToPosition(pos);
    }
}
