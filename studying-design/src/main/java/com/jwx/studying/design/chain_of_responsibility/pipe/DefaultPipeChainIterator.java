package com.jwx.studying.design.chain_of_responsibility.pipe;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 默认责任链迭代器抽象类，其他责任链迭代器继承于此
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: DefaultPipeChainIterator.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/30
 */
public abstract class DefaultPipeChainIterator<I extends IPipeInput,R extends IPipeOutput> implements IPipeIterator {

    private I pipeInput;
    private R pipeResult;
    private IPipeChainListener pipeListener;
    private AtomicInteger nextPipe;
    private List<IPipe> pipeList;

    public abstract void processError(I input,Throwable error,R r);

    DefaultPipeChainIterator(List<IPipe> pipeList,I pipeInput, R pipeResult, IPipeChainListener pipeListener) {
        this.nextPipe       = new AtomicInteger(0);
        this.pipeInput      = pipeInput;
        this.pipeResult     = pipeResult;
        this.pipeListener   = pipeListener;
        this.pipeList = pipeList;
    }

    private void onPipeChainStart() {
        try {
            if (pipeListener != null) {
                pipeListener.onStart(pipeInput, pipeResult);
            }
        } catch (Throwable throwable) {

        }
    }

    private void onPipeChainComplete() {
        try {
            if (pipeListener != null) {
                pipeListener.onComplete(pipeInput, pipeResult);
            }
        } catch (Throwable throwable) {

        }
    }

    @Override
    public void next() {
        try {
            int p = nextPipe.getAndIncrement();
            if (p < pipeList.size()) {
                if (p == 0) {
                    onPipeChainStart();
                }
                IPipe pipe = pipeList.get(p);
                pipe.doPipe(pipeInput, pipeResult,this);
            } else if (p == pipeList.size()){
                onPipeChainComplete();
            }
        } catch (Throwable throwable) {
            try{
                processError(pipeInput,throwable,pipeResult);
            }catch (Throwable t){

            }
            next();
        }
    }

}