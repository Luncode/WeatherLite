package com.luncode.weatherlite.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.hitomi.refresh.view.FunGameRefreshView;
import com.luncode.weatherlite.MainActivity;
import com.luncode.weatherlite.R;
import com.luncode.weatherlite.SwichCity;
import com.luncode.weatherlite.model.WeatherModel;

import java.io.IOException;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private LocationManager locationManager;
    private String locationProvider;
    private Button switch_city;
    private TextView city_name;
    private ListView weather_list;
    private CalendarView calendarView;
    private FunGameRefreshView refreshView;
    final String[] weatherinfo = {""};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.activity_main, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        String url = "https://api.isoyu.com/api/Weather/get_weather?city=成都";
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("ErrotTAG",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.d("TAG", "onResponse: " + response.body().string());
                weatherinfo[0] = response.body().string();
                Log.d("TAG", "onResponse: " +weatherinfo[0]);
                JsontoText();
            }
        });

        //refreshView = (FunGameRefreshView) findViewById(R.id.refresh_hit_block);
        city_name = (TextView) root.findViewById(R.id.city_name);
        calendarView = (CalendarView) root.findViewById(R.id.calendarView);
        switch_city = (Button) root.findViewById(R.id.switch_city);
        weather_list = (ListView) root.findViewById(R.id.weather_list);

        init();


        Intent i = getActivity().getIntent();
        Bundle data = i.getExtras();

        if (data != null) {
            city_name.setText(data.getString("city_name"));
        }

        switch_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SwichCity.class);
                startActivity(intent);
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
               Snackbar.make(getView(),year + "年" + month + "月" + dayOfMonth + "日",Snackbar.LENGTH_SHORT).show();
            }
        });


        String tempdata[] = new String[3];
        for (int b = 0 ; b < tempdata.length; b++){
            tempdata[b]="2"+b+"微风";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,tempdata);
        weather_list.setAdapter(adapter);

        weather_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return root;
    }

    public void init(){

        //获取地理位置管理器
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(getActivity(), "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
            return;
        }
        //获取Location
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if (location != null) {
            //不为空,显示地理位置经纬度
            //city_name.setText("经度"+location.getLongitude()+"纬度"+location.getLatitude());
            Toast.makeText(getActivity(),"经度"+location.getLongitude()+"纬度"+location.getLatitude(),Toast.LENGTH_LONG).show();
            Log.i("TAG","经度"+location.getLongitude()+"纬度"+location.getLatitude());
        }
        //监视地理位置变化
        locationManager.requestLocationUpdates(locationProvider, 1000, 1, locationListener);

    }

    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle arg2) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            //如果位置发生变化,重新显示 如果位置改变，经纬度没有变，不会执行此函数 应该说经纬度发生变化执行此函数
            Log.i("TAG","经度:"+location.getLongitude()+"纬度:"+location.getLatitude());

        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            //移除监听器
            locationManager.removeUpdates(locationListener);
        }
    }

    public void JsontoText(){
        Gson gosn = new Gson();
        WeatherModel weather_info = gosn.fromJson(weatherinfo[0],WeatherModel.class);
//        List<WeatherModel.DataBean.ResultsBean> list = weather_info.getData().getResults();
        System.out.println("[status]:"+weather_info.getData().getStatus());
        System.out.println("[date]:"+weather_info.getData().getDate());
//        System.out.println("[city]:"+list.get(0));
//        System.out.println("[pm2.5]:"+list.get(1));
    }
}
