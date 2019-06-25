package com.neuq.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neuq.R;

public class OrderDetailsActivity extends AppCompatActivity {
    private ListView listView = null;
    private ListView listViewDetail = null;
    private String[] strs = {"订单名称  A1", "时间   2019-6-12", "状态   待拣货", "内容"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle.get("title") != null) {
            String title = bundle.get("title").toString();
            String[] a = title.split("    ");
            strs[0] = "订单名称  " + a[0];
            strs[2] = "状态   已完成";
        }
        listView = findViewById(R.id.order_list);
        listViewDetail = findViewById(R.id.detail);
        initUi();
    }

    public void initUi() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strs);
        listView.setAdapter(arrayAdapter);
        String[] detail = {"鱼           海鲜部", "苹果          水果部", "面包            甜点部", "饮用矿泉水         生活用品部"};
        ArrayAdapter arrayAdapterDetail = new ArrayAdapter(this, android.R.layout.simple_list_item_1, detail);
        listViewDetail.setAdapter(arrayAdapterDetail);
    }
}
