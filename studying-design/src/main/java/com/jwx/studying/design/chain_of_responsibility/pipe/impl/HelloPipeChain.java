package com.jwx.studying.design.chain_of_responsibility.pipe.impl;

import com.jwx.studying.design.chain_of_responsibility.pipe.DefaultPipeChain;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe.impl
 * FileName: HelloPipeChain.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/8/8
 */
public class HelloPipeChain extends DefaultPipeChain<HelloInput,HelloOutput>{
    /**
     * 如果执行过程发生异常，则调用此方法处理异常
     *
     * @param input
     * @param error
     * @param helloOutput
     */
    @Override
    public void handlerError(HelloInput input, Throwable error, HelloOutput helloOutput) {
            System.out.println("HelloPipeChain 执行错误：");
            error.printStackTrace();
    }
}