package com.nighter.router.chain;

/**
 * Create by Nighter on 2019-12-27
 */
public interface IInterceptor {
    void intercept(RouteChain chain, Callback callback);
}
