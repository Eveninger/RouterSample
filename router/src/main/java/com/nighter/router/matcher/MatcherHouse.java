package com.nighter.router.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Nighter on 2020-03-30
 */
public class MatcherHouse {
    private static final List<IMatcher> sAllMatchers = new ArrayList<>();

    static {
        sAllMatchers.add(new DirectMatcher(1000));
    }

    public static List<IMatcher> getAllMatchers() {
        return sAllMatchers;
    }
}
