package com.codingmylife.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
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
    public LinearLayout.LayoutParams params;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linerLay);
        add = findViewById(R.id.add);
        text = findViewById(R.id.editText);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = String.valueOf(text.getText());
                text.setText("");
                if(item.equals(""))
                    Toast.makeText(MainActivity.this,"Input is empty",Toast.LENGTH_SHORT).show();
                else {
                    //create checkBox
                    CheckBox chkTeamName = new CheckBox(getApplicationContext());
                    chkTeamName.setText("  "+item);
                    chkTeamName.setTextSize(25);
                    chkTeamName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            String name = (String) chkTeamName.getText();
                            if(isChecked) {
                                chkTeamName.setText("[✔]"+name);
                            }
                            else {
                                String newName[] = name.split("");
                                name = "";
                                for(int i=3;i<newName.length;i++)
                                    name+=newName[i].toString();
                                chkTeamName.setText(name);
                            }
                        }
                    });
                    chkTeamName.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            return false;
                        }
                    });
                    chkTeamName.setBottom(2);
//                    layout.addView(chkTeamName);

                    //create delete button
                    Button delBtn = new Button(getApplicationContext());
                    delBtn.setText("❌");
                    delBtn.setWidth(10);
                    delBtn.setHeight(10);

                    //create edit button
                    Button editBtn = new Button(getApplicationContext());
                    editBtn.setText("🖊");
                    editBtn.setWidth(10);
                    editBtn.setHeight(10);

                    //add

                    params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    params.setMargins(16, 16, 16, 16);
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                    layout.addView(chkTeamName, params);
                    layout.addView(editBtn, params);
                    layout.addView(delBtn, params);

                    Toast.makeText(MainActivity.this,"Added :"+item,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}