package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
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
        builder.setTitle("식재료 추가");
        builder.setView(view);
        builder.setPositiveButton("추가", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText nText = (EditText)findViewById(R.id.nameText);
                EditText qText = (EditText)findViewById(R.id.quantityText);
                EditText dText = (EditText)findViewById(R.id.duedateText);

                String ingredient = nText.getText().toString();
                Integer quantity = Integer.parseInt(qText.getText().toString());
                String dueDate = dText.getText().toString();

                DbOpenHelper.insertColumn(ingredient, quantity, dueDate);

/*
                adapter.addnewItem(DetectiveNote.this, category, title,main, time, suspect);
                adapter.notifyDataSetChanged();
*/
            }
        });
 /*       builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
*.

  */

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
 /*   public void mOnClose(View v){
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);
        finish();
  }*/
}
