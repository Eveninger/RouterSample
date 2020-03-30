package com.nighter.router;

import android.net.Uri;
import android.os.Bundle;

import com.nighter.router.template.IProvider;

import java.util.Map;

import androidx.annotation.Nullable;

/**
 * Create by Nighter on 2020-03-30
 * 路由获取对象以及跳转需要发送路由请求
 */
public final class RouteRequest {
    private final Uri mUri;
    private Class<? extends IProvider> mProvider;
    private int mFlags;
    private Bundle extras;
    Uri data;
    String type;
    String action;
    // skip all the interceptors
    boolean skipInterceptors;
    @Nullable
    private Map<String, Boolean> mTempInterceptors;
    @Nullable
    private RouteCallback mRouteCallback;
    private int mRequestCode = -1;
    private int mEnterAnim, mExitAnim;
    @Nullable
    private Bundle mActivityOptionsBundle;

    public RouteRequest(Uri uri) {
        mUri = uri;
    }

    public RouteRequest(Class<? extends IProvider> provider) {
        mProvider = provider;
        mUri = Uri.parse(provider.getCanonicalName());
    }

    public Uri getUri() {
        return mUri;
    }
}
