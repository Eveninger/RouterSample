package com.nighter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for injected params.
 * <p>
 * Create by Nighter  on 2017/6/12.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectParam {
    /**
     * Map param field with the specify key that support multiple keys.<br/>
     * if multiple keys match the params of uri, the the latter will overwrite the prior.
     */
    String[] keys() default {};

    /**
     * whether this param is require for inject
     *
     * @return
     */
    boolean required() default false;
}
