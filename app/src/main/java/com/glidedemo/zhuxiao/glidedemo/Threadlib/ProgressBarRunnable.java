package com.glidedemo.zhuxiao.glidedemo.Threadlib;

/**
 * Created by zhuxiao on 2016/5/12.
 */
public abstract class ProgressBarRunnable implements Runnable {
    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    @Override
    public void run() {
       prepareProgressBar();
        pRun();
        closeProgressBar();
    }

    private void closeProgressBar() {
    }

    protected  void prepareProgressBar(){

    }

    /**
     * 当前线程要执行的任务
     */
    public abstract void pRun();
}
