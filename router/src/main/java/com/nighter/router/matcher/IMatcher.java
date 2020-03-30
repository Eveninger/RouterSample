package com.nighter.router.matcher;

import android.content.Context;
import android.net.Uri;

import com.nighter.router.RouteRequest;

import androidx.annotation.Nullable;

/**
 * Create by Nighter on 2020-03-30
 * 路由匹配规则
 */
public interface IMatcher extends Comparable<IMatcher> {
    /**
     * 路由匹配结果
     * @param context
     * @param uri
     * @param route
     * @param routeRequest
     * @return
     */
    boolean match(@Nullable Context context, Uri uri, @Nullable String route, RouteRequest routeRequest);

    /**
     * 匹配成功返回的对象Intent/Fragment/Service?
     * @param context
     * @param uri
     * @param target
     * @return
     */
    Object generate(@Nullable Context context, Uri uri, @Nullable Class<?> target);
}
