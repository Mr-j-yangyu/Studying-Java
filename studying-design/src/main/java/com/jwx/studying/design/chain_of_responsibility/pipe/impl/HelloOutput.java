package com.jwx.studying.design.chain_of_responsibility.pipe.impl;

import com.jwx.studying.design.chain_of_responsibility.pipe.IPipeOutput;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe.impl
 * FileName: HelloOutput.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/31
 */
public class HelloOutput implements IPipeOutput<String>{

    private String result;

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public void write(String content){
        this.result = content;
    }
}