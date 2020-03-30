package com.nighter.router.chain;


import com.nighter.router.RouteResponse;

/**
 * Create by Nighter on 2019-12-27
 */
public interface Callback {
    void onProcess(RouteResponse response);
}
