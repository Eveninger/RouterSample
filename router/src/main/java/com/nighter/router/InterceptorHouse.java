package com.nighter.router;

import com.nighter.router.chain.IInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Nighter on 2020-03-30
 */
public class InterceptorHouse {
    private static final List<IInterceptor> sAllInterceptors = new ArrayList<>();

    public static List<IInterceptor> getAllInterceptors() {
        return sAllInterceptors;
    }

    public static void addInterceptors(IInterceptor interceptor) {
        sAllInterceptors.add(interceptor);
    }

    public static void removeInterceptor(IInterceptor interceptor) {
        sAllInterceptors.remove(interceptor);
    }
}
