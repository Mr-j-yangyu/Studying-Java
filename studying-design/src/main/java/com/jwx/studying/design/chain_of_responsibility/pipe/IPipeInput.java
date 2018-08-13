package com.jwx.studying.design.chain_of_responsibility.pipe;

/**
 * Description: 输入管道接口类
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe
 * FileName: IPipeInput.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/30
 */

public interface IPipeInput{
    /**
     * 获取 输入管道 参数
     *
     * @param
     * @return
     * @author jiwenxiang
     * @date 2018/7/31
     */
     public <T>T read();
}
