package com.nighter.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.nighter.router.chain.Callback;
import com.nighter.router.chain.IntentProcessor;
import com.nighter.router.chain.RouteInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Nighter on 2020-03-30
 */
public class Router {
    public static void go(Context context, final String url, final RouteCallback callback) {
        List<RouteInterceptor> routeInterceptors = new ArrayList<>();
        routeInterceptors.add(new IntentProcessor());

        RouteInterceptorChain chain = new RouteInterceptorChain(context, new RouteRequest(Uri.parse(url)), routeInterceptors);
        chain.process(new Callback() {
            @Override
            public void onProcess(RouteResponse response) {
                if (callback != null) {
                    callback.callback(response.getStatus(), Uri.parse(url), response.getMessage());
                }
            }
        });
    }

    public static Intent getIntent(Context context, String url) {
        List<RouteInterceptor> routeInterceptors = new ArrayList<>();
        routeInterceptors.add(new IntentProcessor());

        RouteInterceptorChain chain = new RouteInterceptorChain(context, new RouteRequest(Uri.parse(url)), routeInterceptors);
        RouteResponse response = chain.process();
        return (Intent) response.getResult();
    }
}
