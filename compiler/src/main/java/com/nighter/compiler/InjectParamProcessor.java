package com.nighter.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * Create by Nighter on 2020-03-30
 */
public class InjectParamProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        /**
         * 生成注入参数方法，类似
         *     PathArgumentActivity realTarget = (PathArgumentActivity)target;
         *     Bundle bundle = realTarget.getIntent().getExtras();
         *     realTarget.mArg1 = bundle.getInt("arg1");
         *     realTarget.mArg2 = bundle.getBoolean("arg2");
         */
        return false;
    }
}
