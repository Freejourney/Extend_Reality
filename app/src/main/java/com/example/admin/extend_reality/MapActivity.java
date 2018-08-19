package com.example.admin.extend_reality;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

public class MapActivity extends Activity {

    public AMapLocationClient aMapLocationClient = null;
    public TextView tv_result;
    public Button btn_locate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        init();
        aMapLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        StringBuffer sb = new StringBuffer();
                        sb.append("定位成功" + "\n");
                        sb.append("定位类型: " + aMapLocation.getLocationType() + "\n");
                        sb.append("经    度    : " + aMapLocation.getLongitude() + "\n");
                        sb.append("纬    度    : " + aMapLocation.getLatitude() + "\n");
                        sb.append("精    度    : " + aMapLocation.getAccuracy() + "米" + "\n");
                        sb.append("提供者    : " + aMapLocation.getProvider() + "\n");

                        sb.append("速    度    : " + aMapLocation.getSpeed() + "米/秒" + "\n");
                        sb.append("角    度    : " + aMapLocation.getBearing() + "\n");
                        // 获取当前提供定位服务的卫星个数
                        sb.append("星    数    : " + aMapLocation.getSatellites() + "\n");
                        sb.append("国    家    : " + aMapLocation.getCountry() + "\n");
                        sb.append("省            : " + aMapLocation.getProvince() + "\n");
                        sb.append("市            : " + aMapLocation.getCity() + "\n");
                        sb.append("城市编码 : " + aMapLocation.getCityCode() + "\n");
                        sb.append("区            : " + aMapLocation.getDistrict() + "\n");
                        sb.append("区域 码   : " + aMapLocation.getAdCode() + "\n");
                        sb.append("地    址    : " + aMapLocation.getAddress() + "\n");
                        sb.append("兴趣点    : " + aMapLocation.getPoiName() + "\n");
                        tv_result.setText(sb.toString());
                    } else {
                        tv_result.setText("定位失败");
                    }
                }
            }
        });
    }

    void init() {
        aMapLocationClient = new AMapLocationClient(getApplicationContext());
        btn_locate = findViewById(R.id.btn_locate);
        btn_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aMapLocationClient.startLocation();
            }
        });
        tv_result = findViewById(R.id.tv_result);
    }
}
