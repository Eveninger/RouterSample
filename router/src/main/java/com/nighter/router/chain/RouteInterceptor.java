package com.nighter.router.chain;

import com.nighter.router.RouteResponse;

import androidx.annotation.NonNull;

/**
 * Create by Nighter on 2019-12-27
 */
public interface RouteInterceptor {
    @NonNull
    RouteResponse intercept(RouteChain chain);
}
