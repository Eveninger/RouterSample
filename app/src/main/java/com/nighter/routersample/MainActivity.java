package com.nighter.routersample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nighter.router.InterceptorHouse;
import com.nighter.router.RouteCallback;
import com.nighter.router.RouteStatus;
import com.nighter.router.Router;
import com.nighter.router.chain.IInterceptor;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实际项目是通过注解生成拦截器，而不是直接像这样添加拦截器
        InterceptorHouse.addInterceptors(new TestAInterceptor());

    }

    public void routeAsync(View view) {
        final IInterceptor b = new TestBInterceptor();
//        InterceptorHouse.addInterceptors(b);
        Router.go(this, "A Page", new RouteCallback() {
            @Override
            public void callback(RouteStatus status, Uri uri, String message) {
                Log.e("route", "跳转结果：" + status);
//                InterceptorHouse.removeInterceptor(b);
            }
        });

    }

    public void routeSync(View view) {
        //同步没有拦截器功能
        Intent intent = Router.getIntent(this, "A Page");
        Log.e("route", "同步跳转到" + intent.getAction());
    }
}
