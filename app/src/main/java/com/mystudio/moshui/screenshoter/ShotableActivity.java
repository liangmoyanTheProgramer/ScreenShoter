package com.mystudio.moshui.screenshoter;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mystudio.moshui.screenshoter.util.Shotable;

public class ShotableActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button buttonShot;
    private Integer count;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shotable);

        buttonShot = (Button)  findViewById(R.id.button_shot);
        count = 0;
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        buttonShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shotable.shot(getWindow().getDecorView(), Environment.getExternalStorageDirectory().getPath(),"shot" + count.toString() +".png");
                count++;

            }
        });

    }

}
