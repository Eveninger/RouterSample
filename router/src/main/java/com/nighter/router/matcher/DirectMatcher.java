package com.nighter.router.matcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.nighter.router.RouteRequest;

import androidx.annotation.Nullable;

/**
 * Create by Nighter on 2019-12-17
 * 直接匹配规则
 */
public final class DirectMatcher extends Matcher {
    public DirectMatcher(int priority) {
        super(priority);
    }

    @Override
    public boolean match(@Nullable Context context, Uri uri, @Nullable String route, RouteRequest routeRequest) {
        return !TextUtils.isEmpty(route) && uri.toString().equals(route);
    }

    @Override
    public Object generate(@Nullable Context context, Uri uri, @Nullable Class<?> target) {
        return super.generate(context, uri, target);
    }
}
