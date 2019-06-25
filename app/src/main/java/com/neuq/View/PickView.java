package com.neuq.View;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neuq.R;

public class PickView {
    private Context context = null;
    private View view = null;
    private ListView listView = null;

    public View getView() {
        return view;
    }

    public PickView(Context context) {
        this.context = context;
        view = View.inflate(context, R.layout.pick, null);
        listView = view.findViewById(R.id.list);
        initUi();
    }

    private void initUi() {
        String array[] = {"西红柿   x15", "黄瓜    x12", "豆角      3.5KG", "甜菜     1KG"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, array);
        listView.setAdapter(arrayAdapter);
    }
}
