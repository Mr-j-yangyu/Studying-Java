package com.jwx.studying.design.chain_of_responsibility.pipe.impl;

import com.jwx.studying.design.chain_of_responsibility.pipe.*;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility.pipe.impl
 * FileName: HelloPipe.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/31
 */
public class HelloPipe implements IPipe<HelloInput,HelloOutput>{


    @Override
    public void doPipe(HelloInput pipeInput, HelloOutput pipeOutput, IPipeIterator iPipeIterator) {
        String lanaguage = pipeInput.read();
        if(lanaguage.equals("chinese")){
            pipeOutput.write("你好");
        }else if (lanaguage.equals("english")){
            pipeOutput.write("hello");
        }else{
            pipeOutput.write("未识别。。。");
        }

        if(iPipeIterator !=null){
            iPipeIterator.next();
        }
    }
}