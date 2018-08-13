package com.jwx.studying.design.chain_of_responsibility;

import com.jwx.studying.design.chain_of_responsibility.pipe.IPipeChainListener;
import com.jwx.studying.design.chain_of_responsibility.pipe.IPipeInput;
import com.jwx.studying.design.chain_of_responsibility.pipe.IPipeOutput;
import com.jwx.studying.design.chain_of_responsibility.pipe.impl.HelloInput;
import com.jwx.studying.design.chain_of_responsibility.pipe.impl.HelloOutput;
import com.jwx.studying.design.chain_of_responsibility.pipe.impl.HelloPipe;
import com.jwx.studying.design.chain_of_responsibility.pipe.impl.HelloPipeChain;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.design.chain_of_responsibility
 * FileName: Start.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/8/8
 */
public class Start {
    public static void main(String[] args) {
        HelloInput hinput = new HelloInput("chinese");
        HelloOutput houtput = new HelloOutput();
        HelloPipeChain hchain = new HelloPipeChain();
        hchain.setPipeList(new HelloPipe());
        hchain.doPipe(hinput, houtput, new IPipeChainListener() {
            @Override
            public void onStart(IPipeInput pipeInput, IPipeOutput pipeResult) {
                System.out.println("HelloChain 开始执行");
            }

            @Override
            public void onComplete(IPipeInput pipeInput, IPipeOutput pipeResult) {
                System.out.println("HelloChain 执行完毕");
            }
        });
        System.out.println(houtput.getResult());
    }
}