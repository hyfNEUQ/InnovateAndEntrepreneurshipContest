package com.neuq.Activity;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.neuq.R;
import com.neuq.View.BrowseView;
import com.neuq.View.HistoryView;
import com.neuq.View.PickView;
import com.neuq.View.QuestionView;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class PickingStaffActivity extends AppCompatActivity {
    private HistoryView historyView = null;
    private BrowseView browseView = null;
    private PickView pickView = null;
    private QuestionView questionView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples_ntb);
        pickView = new PickView(this);
        questionView = new QuestionView(this);
        historyView=new HistoryView(this);
        browseView=new BrowseView(this);
        initUI();
    }

    //用于初始化ViewPager
    private void initUI() {
        final ViewPager viewPager = findViewById(R.id.vp_horizontal_ntb);
        if(viewPager==null) System.out.println("null");
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                View view = null;
                switch (position) {
                    case 0:
                        view = historyView.getView();
                        break;
                    case 1:
                        view = browseView.getView();
                        break;
                    case 2:
                        view = pickView.getView();
                        break;
                    case 3:
                        view = questionView.getView();
                        break;
                }
                container.addView(view);
                return view;
            }
        });
        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.history),
                        Color.parseColor(colors[0]))
                        .selectedIcon(getResources().getDrawable(R.drawable.history))
                        .title("历史")
                        .badgeTitle("history")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.eye),
                        Color.parseColor(colors[1]))
                        .selectedIcon(getResources().getDrawable(R.drawable.eye))
                        .title("查看")
                        .badgeTitle("view")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.pick),
                        Color.parseColor(colors[1]))
                        .selectedIcon(getResources().getDrawable(R.drawable.pick))
                        .title("拣货")
                        .badgeTitle("pick")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.question),
                        Color.parseColor(colors[1]))
                        .selectedIcon(getResources().getDrawable(R.drawable.question))
                        .title("问题")
                        .badgeTitle("question")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }
}
