package com.neuq.View;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neuq.R;

public class QuestionView {
    private Context context = null;
    private View view = null;
    private ListView listView = null;

    public View getView() {
        return view;
    }
    public QuestionView(Context context) {
        this.context = context;
        view = View.inflate(context, R.layout.question, null);
        listView=view.findViewById(R.id.list);
        initUi();
    }
    private void initUi() {
        String array[] = {"单号    A123", "状态     待拣货", "问题原因    拣货超时", "超时部门  水果部","水果部负责人      XX","联系方式  132309******"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, array);
        listView.setAdapter(arrayAdapter);
    }
}
