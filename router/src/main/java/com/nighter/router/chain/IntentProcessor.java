package com.nighter.router.chain;

import android.content.Intent;

import com.nighter.router.RouteInterceptorChain;
import com.nighter.router.RouteResponse;
import com.nighter.router.RouteStatus;
import com.nighter.router.matcher.IMatcher;
import com.nighter.router.matcher.MatcherHouse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create by Nighter on 2020-03-30
 */
public class IntentProcessor implements RouteInterceptor {
    @NonNull
    @Override
    public RouteResponse intercept(RouteChain chain) {
        RouteInterceptorChain routeChain = (RouteInterceptorChain) chain;
        List<IMatcher> matchers = MatcherHouse.getAllMatchers();

        //匹配路由规则
        Intent intent = matchIntent(matchers);
        if (intent == null) {
            return RouteResponse.assemble(RouteStatus.Failed, "not found intent");
        }
        routeChain.mTargetObject = intent;
        //责任链传递
        return chain.process();
    }

    /**
     * 这里会调用根据Matcher匹配到对应目标对象
     *
     * @param matchers
     * @return
     */
    @Nullable
    private Intent matchIntent(List<IMatcher> matchers) {
        Intent intent = new Intent();
        intent.setAction("A Page");
        return intent;
    }
}
