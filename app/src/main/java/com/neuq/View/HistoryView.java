package com.neuq.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neuq.Activity.OrderDetailsActivity;
import com.neuq.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryView {
    private Context context = null;
    private View view = null;
    private ListView listView = null;
    private SearchView searchView = null;
    private String array[];
    public View getView() {
        return view;
    }

    public HistoryView(Context context) {
        this.context = context;
        view = View.inflate(context, R.layout.history_view, null);
        listView = view.findViewById(R.id.history_listview);
        array= new String[]{"A8    已完成", "A7    已完成", "A6    已完成", "A5    已完成"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, array);
        listView.setAdapter(arrayAdapter);
        initUi();
    }

    private void initUi() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(context, OrderDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("title",array[i]);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }
}
