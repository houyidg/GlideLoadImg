package com.glidedemo.zhuxiao.glidedemo.utils;

import android.util.Log;

import com.glidedemo.zhuxiao.glidedemo.Threadlib.ProgressBarRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhuxiao on 2016/5/11.
 */
public class ThreadPoolUtil {
    private static final String TAG = "ThreadPoolUtil";
    private static final boolean isDebug = Constants.DEBUG;
    private static ThreadPoolUtil instance = new ThreadPoolUtil();
    public static ThreadPoolUtil getInstance(){
        return instance;
    }
    private ExecutorService mSingleThreadPool;//只含有一个线程的线程池
    private ThreadPoolExecutor mShortPool;
    public void executeTaskBySingleThreadPool(ProgressBarRunnable task){
        synchronized (instance){
            if(isDebug){
                Log.d(TAG,"task before:");
            }
            if (mSingleThreadPool==null){
                mSingleThreadPool = Executors.newSingleThreadExecutor();
            }
            //先关闭先前的任务
            if(mSingleThreadPool.isShutdown()){
                mSingleThreadPool.shutdown();
            }
            /*Executes the given command at some time in the future. The command may execute in a new thread,
            in a pooled thread, or in the calling thread, at the discretion of the Executor implementation.*/
            mSingleThreadPool.execute(task);
            if(isDebug){
                Log.d(TAG,"task after:");
            }
            /*Submits a Runnable task for execution and returns a Future representing that task. The Future's get method will return null upon successful completion.
            * */
//            mSingleThreadPool.submit(task);//最终执行execute
        }
    }
}
