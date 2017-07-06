package com.glidedemo.zhuxiao.glidedemo.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
/**
 * 这是一个工作线程消息循环队列，在没有任务的时候可以在制定的时间内退出线程。<br/>
 * 在调用诸如{@link #sendEmptyMessage(int)}方法的时候，调用者不用关心线程启动都细节，
 * 可以保证{@link #handleMessage(Message)}是单线程执行的，但thread id可能不同
 * @author zhangdi
 *
 */
public abstract class HandlerThreadExecutor {
    private static final boolean DEBUG = true;
    private static final String TAG =  "HandlerThreadExecutor";

    private final Object mLocker = new Object();

    private String mThreadName;
    private volatile HandlerThread mHandlerThread;

    private Handler mHandler;

    private static final int MSG_CHECK = Integer.MIN_VALUE + 250;

    private int mMinMsg = 0;
    private int mMaxMsg = 0;

    private long mQuitDelta;

    public HandlerThreadExecutor( String threadName, int minMsg, int maxMsg, long quitDelta) {
        mThreadName = threadName;
        if (minMsg > maxMsg) {
            throw new IllegalArgumentException();
        }
        mMinMsg = minMsg;
        mMaxMsg = maxMsg;

        mQuitDelta = Math.max(quitDelta, 5 * 1000);
    }

    public HandlerThreadExecutor(String threadName, int maxMsg, long quitDelta) {
        this(threadName, 0, maxMsg, quitDelta);
    }

    private void ensureHandlerTheadStartedLocked() {
        //synchronized (mLocker) {
        if (mHandlerThread == null) {
            if (DEBUG) {
                Log.d(TAG, "[ensureHandlerTheadStartedLocked] start new thread");
            }
            mHandlerThread = new HandlerThread(mThreadName);
            mHandlerThread.start();
//            mHandlerThread.interrupt();
            mHandler = new Handler(mHandlerThread.getLooper(), new HanlderCallback());
        }
        //}
    }

    private void checkMsg(int msgWhat) {
        if (msgWhat == MSG_CHECK) {
            throw new IllegalStateException();
        }
    }

    private class HanlderCallback implements Handler.Callback {
        private boolean mRecycled = false;

        public boolean handleMessage(Message msg) {
            if (mRecycled) {
                return true;
            }
            if (msg.what == MSG_CHECK) {
                if (DEBUG) {
                    Log.d(TAG, "[CHECK]");
                }
                boolean quitLoop = true;
                synchronized (mLocker) {
                    for (int i = mMinMsg; i <= mMaxMsg; i++) {
                        if (mHandler != null) {
                            if (mHandler.hasMessages(i)) {//是否有msg 
                                quitLoop = false;
                                break;
                            }
                        }
                    }
                    if (quitLoop && mHandlerThread != null) {//quit 
                        if (DEBUG) {
                            Log.d(TAG, "[really quit]");
                        }
                        if (onLoopQuit()) {
                            mRecycled = true;
                            mHandlerThread.quit();
                            mHandlerThread = null;
                            mHandler = null;
                            return true;
                        }
                    }
                }
            }

            HandlerThreadExecutor.this.handleMessage(msg);//处理
            synchronized (mLocker) {
                if (mHandler != null) {
                    mHandler.removeMessages(MSG_CHECK);
                    mHandler.sendEmptyMessageDelayed(MSG_CHECK, mQuitDelta);
                }
            }

            return true;
        }
    }

    /**
     * 是否要退出循环进程
     * @return true if 退出
     */
    protected boolean onLoopQuit() {
        return true;
    }

    public abstract void handleMessage(Message msg);
    
    
    public final void sendMessage(int what, int arg1, int arg2, Object obj) {
        checkMsg(what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            mHandler.obtainMessage(what, arg1, arg2, obj).sendToTarget();
        }
    }
    
    /**
     * Pushes a message onto the end of the message queue after all pending messages
     * before the current time. It will be received in {@link #handleMessage},
     * in the thread attached to this handler.
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting.
     */
    public final boolean sendMessage(Message msg) {
        checkMsg(msg.what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendMessage(msg);
        }
    }

    /**
     * Sends a Message containing only the what value.
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting.
     */
    public final boolean sendEmptyMessage(int what) {
        checkMsg(what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendEmptyMessage(what);
        }
    }

    /**
     * Sends a Message containing only the what value, to be delivered
     * after the specified amount of time elapses.
     * 
     * @see #sendMessageDelayed(Message, long)
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting.
     */
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        checkMsg(what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendEmptyMessageDelayed(what, delayMillis);
        }
    }

    /**
     * Sends a Message containing only the what value, to be delivered
     * at a specific time.
     * 
     * @see #sendMessageAtTime(Message, long)
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting.
     */

    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        checkMsg(what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendEmptyMessageAtTime(what, uptimeMillis);
        }
    }

    /**
     * Enqueue a message into the message queue after all pending messages
     * before (current time + delayMillis). You will receive it in {@link #handleMessage}, in the thread attached to
     * this handler.
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting. Note that a
     *         result of true does not mean the message will be processed -- if
     *         the looper is quit before the delivery time of the message
     *         occurs then the message will be dropped.
     */
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        checkMsg(msg.what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendMessageDelayed(msg, delayMillis);
        }
    }

    /**
     * Enqueue a message into the message queue after all pending messages
     * before the absolute time (in milliseconds) <var>uptimeMillis</var>.
     * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
     * You will receive it in {@link #handleMessage}, in the thread attached
     * to this handler.
     * 
     * @param uptimeMillis
     *            The absolute time at which the message should be
     *            delivered, using the {@link android.os.SystemClock#uptimeMillis} time-base.
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting. Note that a
     *         result of true does not mean the message will be processed -- if
     *         the looper is quit before the delivery time of the message
     *         occurs then the message will be dropped.
     */
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        checkMsg(msg.what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendMessageAtTime(msg, uptimeMillis);
        }
    }

    /**
     * Enqueue a message at the front of the message queue, to be processed on
     * the next iteration of the message loop. You will receive it in {@link #handleMessage}, in the thread attached to
     * this handler.
     * <b>This method is only for use in very special circumstances -- it
     * can easily starve the message queue, cause ordering problems, or have
     * other unexpected side-effects.</b>
     * 
     * @return Returns true if the message was successfully placed in to the
     *         message queue. Returns false on failure, usually because the
     *         looper processing the message queue is exiting.
     */
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        checkMsg(msg.what);
        synchronized (mLocker) {
            ensureHandlerTheadStartedLocked();
            return mHandler.sendMessageAtFrontOfQueue(msg);
        }
    }

    /**
     * Remove any pending posts of messages with code 'what' that are in the
     * message queue.
     */
    public final void removeMessages(int what) {
        synchronized (mLocker) {
            if (mHandler != null) {
                mHandler.removeMessages(what);
            }
        }
    }
}
