package com.nighter.routersample;

import android.net.Uri;
import android.os.Handler;

import com.nighter.router.RouteInterceptorChain;
import com.nighter.router.RouteRequest;
import com.nighter.router.chain.Callback;
import com.nighter.router.chain.IInterceptor;
import com.nighter.router.chain.RouteChain;

/**
 * Create by Nighter on 2020-03-30
 */
public class TestBInterceptor implements IInterceptor {
    @Override
    public void intercept(final RouteChain chain, final Callback callback) {
        final RouteInterceptorChain routeChain = (RouteInterceptorChain) chain;
        RouteRequest request = routeChain.getRequest();
        Uri uri = request.getUri();

        //异步验证
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                routeChain.intercept("不允许跳转，拦截！", callback);
            }
        }, 500);
    }

}
