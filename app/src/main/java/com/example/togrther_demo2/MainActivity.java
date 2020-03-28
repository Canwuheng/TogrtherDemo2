package com.example.togrther_demo2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.togrther_demo2.Fragment.TebFragment1;
import com.example.togrther_demo2.Fragment.TebFragment2;
import com.example.togrther_demo2.Fragment.TebFragment3;
import com.example.togrther_demo2.Fragment.TebFragment4;
import com.example.togrther_demo2.Fragment.TebFragment5;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout content_view;
    private TextView tv_toolbar;
    private Toolbar my_toolbar;
    private NavigationView navigation_view;
    private DrawerLayout drawerlayout;
    private List<Fragment> fragmentList=new ArrayList<>();
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();


        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                switch (item.getItemId()) {

                    case R.id.nav_dmv:
                        swichfragment(0);
                        break;
                    case R.id.nav_light:
                        swichfragment(2);
                        break;
                    case R.id.nav_mycar:
                        swichfragment(1);
                        break;
                    case R.id.nav_threshold:
                        swichfragment(3);
                        break;
                    case R.id.nav_sub:
                        swichfragment(4);
                        break;
                }
                drawerlayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });

        my_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerlayout.openDrawer(Gravity.LEFT);
            }
        });
        }

    private void initView() {
        content_view = (FrameLayout) findViewById(R.id.content_view);
//        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        my_toolbar = (Toolbar) findViewById(R.id.mytoolbar);

        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        //初始化碎片列表
        fragmentList.add(new TebFragment1());
        fragmentList.add(new TebFragment2());
        fragmentList.add(new TebFragment3());
        fragmentList.add(new TebFragment4());
        fragmentList.add(new TebFragment5());
        //第一页初始化
        currentFragment = fragmentList.get(0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_view, currentFragment).commit();

    }

    public void swichfragment( int position) {
        Fragment fragment = fragmentList.get(position);
        if (currentFragment != fragment) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            if (fragment.isAdded()) {
                fragmentTransaction.hide(currentFragment).show(fragment).commit();
            } else {
                fragmentTransaction.hide(currentFragment).add(R.id.content_view, fragment).commit();

            }

        }
    }
}
