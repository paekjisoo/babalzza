package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private ImageButton ib1_1, ib1_2, ib2_1, ib2_2;
    private EditText nText, qText, dText;
    private DbOpenHelper mDbOpenHelper;

    @Override
    // 식자재 버튼 create
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ib1_1 = (ImageButton)findViewById(R.id.imageButton1_1);
        ib1_2 = (ImageButton)findViewById(R.id.imageButton1_2);
        ib2_1 = (ImageButton)findViewById(R.id.imageButton2_1);
        ib2_2 = (ImageButton)findViewById(R.id.imageButton2_2);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        // foodcontroller 선언 후 해당 컨트롤러로 처리
        ib1_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();
            }
        });
        ib1_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();
            }
        });
        ib2_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();
            }
        });
        ib2_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }
    
    void add(/*final Context context /*, final NoteAdapter adapter*/){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater_dg = getLayoutInflater();
        final View view = inflater_dg.inflate(R.layout.activity_add_popup, null);
        builder.setView(view);
        builder.setPositiveButton("추가", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nText = (EditText)view.findViewById(R.id.nameText);
                qText = (EditText)view.findViewById(R.id.quantityText);
                dText = (EditText)view.findViewById(R.id.duedateText);

                String ingredient = nText.getText().toString();
                Integer quantity = Integer.parseInt(qText.getText().toString());
                String dueDate = dText.getText().toString();

                // 데이터베이스 call 및 저장
                DbOpenHelper.insertColumn(ingredient, quantity, dueDate);

            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
}
