package com.jwx.studying.design.chain_of_responsibility.pipe;

/**
 * Description: 管道输出类接口
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: IPipeOutput.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/30
 */
public interface IPipeOutput<T>{

    public <E> E getResult();

    public void write(T content) throws Exception;
}
