package com.nighter.router;

import com.nighter.router.chain.Callback;
import com.nighter.router.chain.IInterceptor;
import com.nighter.router.chain.RouteChain;
import com.nighter.router.chain.RouteInterceptor;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create by Nighter on 2019-12-27
 */
public final class RouteInterceptorChain implements RouteChain {
    private RouteRequest mRequest;
    private final List<RouteInterceptor> mRouteInterceptors;

    private int mRouteIndex, mAppIndex;
    @Nullable
    public Object mTargetObject; // Intent, Fragment, Provider instance
    private RouteResponse mRouteResponse;

    public RouteInterceptorChain(RouteRequest request, List<RouteInterceptor> routeInterceptors) {
        mRequest = request;
        mRouteInterceptors = routeInterceptors;
    }

    public RouteInterceptorChain(Object source, RouteRequest request, List<RouteInterceptor> routeInterceptors) {
        mRequest = request;
        mRouteInterceptors = routeInterceptors;
    }

    /**
     * 异步处理路由
     *
     * @param callback
     */
    @Override
    public void process(Callback callback) {
        /**
         * 匹配过程是同步的
         */
        RouteResponse response = process();

        /**
         * 拦截过程是异步的
         */
        List<IInterceptor> appInterceptors = InterceptorHouse.getAllInterceptors();
        next(appInterceptors, response, callback);
    }

    private void next(List<IInterceptor> appInterceptors, RouteResponse response, Callback callback) {
        if (mAppIndex >= appInterceptors.size()) {
            callback.onProcess(response);
            return;
        }
        IInterceptor interceptor = appInterceptors.get(mAppIndex++);
        interceptor.intercept(this, callback);
    }

    @Override
    public void intercept(String message, Callback callback) {
        callback.onProcess(intercept(message));
    }


    /**
     * 同步处理路由
     *
     * @return
     */
    @NonNull
    @Override
    public RouteResponse process() {
        if (mRouteResponse != null) {
            return mRouteResponse;
        }
        if (mRouteIndex >= mRouteInterceptors.size()) {
            mRouteResponse = RouteResponse.assemble(RouteStatus.Successful, null);
            if (mTargetObject != null) {
                mRouteResponse.setResult(mTargetObject);
            } else {
                mRouteResponse.setStatus(RouteStatus.Failed);
            }
            return mRouteResponse;
        }
        RouteInterceptor interceptor = mRouteInterceptors.get(mRouteIndex++);
        return interceptor.intercept(this);
    }

    /**
     * 同步拦截路由
     *
     * @param message
     * @return
     */
    @NonNull
    @Override
    public RouteResponse intercept(String message) {
        return RouteResponse.assemble(RouteStatus.Intercepted, message);
    }

    public RouteRequest getRequest() {
        return mRequest;
    }
}
