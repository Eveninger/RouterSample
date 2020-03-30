package com.nighter.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * Create by Nighter on 2020-03-30
 */
public class RouteProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        /**
         * 生成路由器表
         * {"url": Activity/Frgmemt/Service}
         */
        return false;
    }
}
