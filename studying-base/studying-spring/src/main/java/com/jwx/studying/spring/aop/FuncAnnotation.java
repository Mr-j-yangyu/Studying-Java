package com.jwx.studying.spring.aop;

import java.lang.annotation.*;

/**
 * PackageName:annotation
 * FileName: MethondAnnocation.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/6/4
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FuncAnnotation {

    String notes() default "默认注释";
}
