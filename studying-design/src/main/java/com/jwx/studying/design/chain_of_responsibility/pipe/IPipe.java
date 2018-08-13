package com.jwx.studying.design.chain_of_responsibility.pipe;

/**
 * Description: 管道接口类
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: IPipe.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/30
 */
public interface IPipe<I extends IPipeInput,R extends IPipeOutput>{

   void doPipe(I pipeInput, R pipeOutput, IPipeIterator iPipeIterator);

}