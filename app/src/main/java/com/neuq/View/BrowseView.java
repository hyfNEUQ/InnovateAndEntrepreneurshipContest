package com.neuq.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neuq.Activity.OrderDetailsActivity;
import com.neuq.R;

public class BrowseView {
    private View view = null;
    private Context context = null;
    private ListView listView = null;

    public BrowseView(Context context) {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.browse_view, null);
        listView = view.findViewById(R.id.history_listview);
        String array[] = {"A1   待拣货", "A2    待内控把关", "A3      待配送", "A4     已完成"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, array);
        listView.setAdapter(arrayAdapter);
        initUi();
    }

    public View getView() {
        return view;
    }

    private void initUi() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(context, OrderDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
