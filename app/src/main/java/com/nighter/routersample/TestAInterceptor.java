package com.nighter.routersample;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import com.nighter.router.RouteInterceptorChain;
import com.nighter.router.RouteRequest;
import com.nighter.router.chain.Callback;
import com.nighter.router.chain.IInterceptor;
import com.nighter.router.chain.RouteChain;

/**
 * Create by Nighter on 2020-03-30
 */
public class TestAInterceptor implements IInterceptor {
    @Override
    public void intercept(final RouteChain chain, final Callback callback) {
        RouteInterceptorChain routeChain = (RouteInterceptorChain) chain;
        RouteRequest request = routeChain.getRequest();
        Uri uri = request.getUri();

        //异步验证
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //不拦截此次跳转，继续跳到目标页
                chain.process(callback);
                //跳转到目标页后，弹出一个新页面
                Log.e("route", "弹出一个新页面");

                //顺序是一致的
            }
        }, 500);
    }

}
