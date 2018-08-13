package com.jwx.studying.design.chain_of_responsibility.pipe;

/**
 * Description: 责任链类接口
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: IPipeChain.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/30
 */
public interface IPipeChain<I extends IPipeInput,R extends IPipeOutput> {
    public void doPipe(I pipeInput, R pipeResult, IPipeChainListener listener);
    public void doPipe(I pipeInput, R pipeResult);
}
