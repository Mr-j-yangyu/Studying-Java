package com.jwx.studying.design.chain_of_responsibility.pipe.impl;

import com.jwx.studying.design.chain_of_responsibility.pipe.IPipeInput;
import lombok.Data;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe.impl
 * FileName: HelloInput.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/31
 */
public class HelloInput implements IPipeInput{

    private String language;

    public HelloInput(String language)
    {
        this.language=language;
    }
    /**
     * 写入 输入管道 参数
     *
     * @param
     * @return
     */
    @Override
    public String read() {
        return this.language;
    }


}