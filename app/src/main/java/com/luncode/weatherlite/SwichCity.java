package com.luncode.weatherlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.luncode.weatherlite.ui.home.HomeFragment;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;

import java.util.ArrayList;
import java.util.List;

public class SwichCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);


        List<HotCity> hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100")); //code为城市代码
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        CityPicker.from(this) //activity或者fragment
                .enableAnimation(true)	//启用动画效果，默认无
                .setOnPickListener(new OnPickListener() {
                        @Override
                    public void onPick(int position, City data) {
                        //Toast.makeText(getApplicationContext(), data.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SwichCity.this,navigation.class);
                        Bundle b=new Bundle();
                        b.putString("city_name",data.getName());
                        b.putString("city_code",data.getCode());
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();
                    }


                    @Override
                    public void onCancel(){
                        //Toast.makeText(getApplicationContext(), "取消选择", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SwichCity.this, navigation.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onLocate() {
                        //定位接口，需要APP自身实现，这里模拟一下定位
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                //定位完成之后更新数据
//                                CityPicker.from()
//                                        .locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
//                            }
//                        }, 3000);
                    }
                })
                .show();
        
    }
}
