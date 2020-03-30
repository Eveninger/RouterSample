package com.nighter.router.matcher;

import android.content.Context;
import android.net.Uri;

import com.nighter.router.RouteRequest;

import androidx.annotation.Nullable;

/**
 * Create by Nighter on 2020-03-30
 * 所有路由匹配规则的基类
 */
public class Matcher implements IMatcher {
    private int mPriority;

    public Matcher(int priority) {
        mPriority = priority;
    }

    @Override
    public boolean match(@Nullable Context context, Uri uri, @Nullable String route, RouteRequest routeRequest) {
        return false;
    }

    @Override
    public Object generate(@Nullable Context context, Uri uri, @Nullable Class<?> target) {
        return null;
    }

    /**
     * 根据mPriority跳转路由优先级
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(IMatcher o) {
        return 0;
    }
}
