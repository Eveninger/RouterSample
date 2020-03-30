package com.nighter.router.chain;


import com.nighter.router.RouteResponse;

import androidx.annotation.NonNull;


/**
 * Create by Nighter on 2019-12-27
 */
public interface RouteChain {

    /**
     * 同步处理路由请求
     */
    @NonNull
    RouteResponse process();

    /**
     * 拦截此次路由请求
     */
    @NonNull
    RouteResponse intercept(String message);

    /**
     * 异步处理路由请求
     *
     * @param callback
     */
    void process(Callback callback);

    /**
     * 异步拦截路由请求
     *
     * @param message
     * @param callback
     */
    void intercept(String message, Callback callback);
}
