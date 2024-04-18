package com.example.trackyourscrolls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    boolean logIn = false;
    ArrayList<ZoneModel>zoneModels = new ArrayList<>();
    ImageButton menuSheet,profileSheet;

    User testuser = new User("test","test123");
    String loggedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupZoneModel();
        RecyclerView recyclerView = findViewById(R.id.RVZone);
        Zone_Adapter adapter = new Zone_Adapter(this, zoneModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menuSheet = findViewById(R.id.btnMenu);
        profileSheet = findViewById(R.id.btnProfile);
        menuSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logIn == true){
                    showDialogmenuUnlog();
                }
                else {
                    showDialogmenuUnlog();
                }

            }
        });

        profileSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logIn == true){
                    showDialogProfileIn();
                    

                }
                else {
                    showDialogProfileOut();
                }

            }
        });


    }

    private void addNewZone(){

    }

    private void showAddScroll(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_addcontentzone);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.TOP);


    }

    private void showDialogProfileIn(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.profile_layout_in);

        ImageButton btnLogOut = dialog.findViewById(R.id.btnLogout);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn = false;
                Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                dialog.hide();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.TOP);




    }

    private void showDialogProfileOut(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.profile_layout_out);

        ImageButton btnLogIn = dialog.findViewById(R.id.btnLogIn);
        final EditText userIn = (EditText) dialog.findViewById(R.id.usernamefield);
        final EditText userPass = (EditText) dialog.findViewById(R.id.passwordfield);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkLogin(userIn.getText().toString(),userPass.getText().toString())){
                    Toast.makeText(MainActivity.this, "Log in Sucess", Toast.LENGTH_SHORT).show();
                    logIn = true;
                    dialog.hide();
                }else {
                    Toast.makeText(MainActivity.this, "Check Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.TOP);
    }

    private void showDialogmenuUnlog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu_layout_mainunlog);

        LinearLayout layoutHome = dialog.findViewById(R.id.layoutHomeUL);
        LinearLayout layoutZone = dialog.findViewById(R.id.layoutZoneUL);

        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,ActivityZone.class);
                dialog.hide();
                startActivity(intent);
            }
        });
        
        layoutZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddScroll();
                dialog.hide();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.TOP);
    }

    private void setupZoneModel(){
        String[] zoneNames = getResources().getStringArray(R.array.zone_name);
        String[] zoneText = getResources().getStringArray(R.array.zone_drop);
        String[] zoneImg = getResources().getStringArray(R.array.zone_img);

        for (int i = 0; i<zoneNames.length; i++){
            zoneModels.add(new ZoneModel(zoneNames[i],zoneText[i],zoneImg[i]));
        }
    }

    private boolean checkLogin(String userIn,String userPass){
        if (Objects.equals(userIn, testuser.getUserName())){
            if (testuser.checkPassword(userPass)){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }


    }

}