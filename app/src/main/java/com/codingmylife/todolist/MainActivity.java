package com.codingmylife.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button add, del, edit;
    EditText text;
    ListView list;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linerLay);
        add = findViewById(R.id.add);
        del = findViewById(R.id.delete);
        edit = findViewById(R.id.edit);
        text = findViewById(R.id.editText);
        del.setEnabled(false);
        edit.setEnabled(false);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = String.valueOf(text.getText());
                text.setText("");
                if(item.equals(""))
                    Toast.makeText(MainActivity.this,"Input is empty",Toast.LENGTH_SHORT).show();
                else {

                    CheckBox chkTeamName = new CheckBox(getApplicationContext());
                    chkTeamName.setText(item);
                    chkTeamName.setTextSize(28);
                    chkTeamName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                            if(buttonView.isChecked()) buttonView.setTextColor(android.R.color.holo_red_light);
//                            else buttonView.setTextColor(android.R.color.black);
                        }
                    });
                    chkTeamName.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            return false;
                        }
                    });
                    chkTeamName.setPadding(3,3,3,5);
                    chkTeamName.setBottom(2);
                    layout.addView(chkTeamName);
                }
            }
        });
    }
}