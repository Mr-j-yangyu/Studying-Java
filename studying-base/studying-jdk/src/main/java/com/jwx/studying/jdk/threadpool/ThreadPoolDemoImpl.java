package com.jwx.studying.jdk.threadpool;

import java.util.List;

/**
 * PackageName:com.jwx.studying.jdk.threadpool
 * FileName: ThreadPoolDemoImpl.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/15
 */
public class ThreadPoolDemoImpl implements ThreadPoolDemo {
    @Override
    public void execute(Runnable task) {

    }

    @Override
    public void execute(Runnable[] tasks) {

    }

    @Override
    public void execute(List<Runnable> tasks) {

    }

    @Override
    public int getExecuteTaskNumber() {
        return 0;
    }

    @Override
    public int getWaitTaskNumber() {
        return 0;
    }

    @Override
    public int getWorkThreadNumber() {
        return 0;
    }

    @Override
    public void destroy() {

    }
}
