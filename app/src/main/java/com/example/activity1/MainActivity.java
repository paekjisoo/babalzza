package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2, fab3;

    // 메인화면 우측 하단 floating button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.close);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab1 = (FloatingActionButton) findViewById(R.id.createButton);
        fab2 = (FloatingActionButton) findViewById(R.id.modifyButton);
        fab3 = (FloatingActionButton) findViewById(R.id.deleteButton);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
    }

    // floating button 클릭 효과
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.floatingActionButton:
                anim();
                break;
            case R.id.createButton:
                anim();
                Toast.makeText(this, "추가", Toast.LENGTH_SHORT).show();
                Intent addintent= new Intent(MainActivity.this, AddActivity.class);
                MainActivity.this.startActivity(addintent);
                break;
            case R.id.modifyButton:
                anim();
                Toast.makeText(this, "수정", Toast.LENGTH_SHORT).show();
                break;
            case R.id.deleteButton:
                anim();
                Toast.makeText(this, "삭제", Toast.LENGTH_SHORT).show();
                break;
            }
    }

    // 버튼 애니메이션 효과
    public void anim() {
        if (isFabOpen) {
            fab3.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isFabOpen = false;
        } else {
            fab3.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;
        }
    }
}
