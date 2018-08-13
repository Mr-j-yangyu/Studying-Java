package com.jwx.studying.design.chain_of_responsibility.pipe;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Description: 默认责任链抽象类，其他责任链继承于此
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe.impl
 * FileName: DefaultPipeChain.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/31
 */
public abstract class DefaultPipeChain<I extends IPipeInput,R extends IPipeOutput> implements IPipeChain<I,R>{

    private List<IPipe> pipeList = null;

    /**
     * 如果执行过程发生异常，则调用此方法处理异常 将error处理成result的结果
     * @param input
     * @param error
     * @param r
     */
    public abstract void handlerError(I input,Throwable error,R r);

    public void setPipeList(IPipe... ipipes){
        setPipeList(Lists.newArrayList(ipipes));
    }
    public void setPipeList(List<IPipe> pipeList) {
        this.pipeList = pipeList;
    }

    /**
     * 启动责任链
     * @param pipeInput
     * @param pipeResult
     */
    public void doPipe(final I pipeInput, final R pipeResult, final IPipeChainListener listener) {
        DefaultPipeChainIterator<I,R> pipeChainIterator = new DefaultPipeChainIterator<I, R>(pipeList,pipeInput, pipeResult, listener) {
            @Override
            public void processError(I input, Throwable error, R r) {
                handlerError(input,error,r);
            }
        };
        pipeChainIterator.next();
    }

    public void doPipe(final I pipeInput, final R pipeResult){
        doPipe(pipeInput,pipeResult,null);
    }

}
