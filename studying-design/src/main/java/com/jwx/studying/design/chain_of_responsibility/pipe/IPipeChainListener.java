package com.jwx.studying.design.chain_of_responsibility.pipe;

/**
 * Description: 责任链监听类接口
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: IPipeChainListener.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/31
 */
public interface IPipeChainListener<I extends IPipeInput,R extends IPipeOutput> {
    /**
     * 责任链开始执行前调用
     */
    void onStart(I pipeInput, R pipeResult);
    /**
     * 责任链执行完毕后调用
     */
    void onComplete(I pipeInput, R pipeResult);
}