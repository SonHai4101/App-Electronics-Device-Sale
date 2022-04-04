package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewtrangchu;
    NavigationView navigationView;
    ListView listViewtrangchu;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Anhxa();
        ActionBar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cdn.cellphones.com.vn/media/ltsoft/promotion/iPhone_11.png");
        mangquangcao.add("https://cdn.cellphones.com.vn/media/ltsoft/promotion/S22_uLTRA.png");
        mangquangcao.add("https://cdn.cellphones.com.vn/media/ltsoft/promotion/Note_11_pro_plus.png");
        mangquangcao.add("https://cdn.cellphones.com.vn/media/ltsoft/promotion/TV.png");
        for (int i = 0; i < mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void Anhxa(){
        toolbar  = (Toolbar) findViewById(R.id.toolbartrangchu);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerViewtrangchu = (RecyclerView) findViewById(R.id.recyclerview);
        navigationView = (NavigationView)  findViewById(R.id.navigationview);
        listViewtrangchu = findViewById(R.id.listviewtrangchu);
        drawerLayout = findViewById(R.id.drawerlayout);

    }

}