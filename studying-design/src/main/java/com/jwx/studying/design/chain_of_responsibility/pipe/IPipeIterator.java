package com.jwx.studying.design.chain_of_responsibility.pipe;

/**
 * Description: 责任链迭代器接口类
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: IPipeIterator.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/30
 */
public interface IPipeIterator {
    /**
     * 触发下一个pipe执行
     */
    public void next();
}
