package com.nighter.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * Create by Nighter on 2020-03-30
 */
public class InterceptorProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        /**
         * 生成拦截器表
         * {"name": Interceptor}
         */
        return false;
    }
}
