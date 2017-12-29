package com.bestcode.sourcecode.concurrent.locks;

import java.util.concurrent.TimeUnit;

public interface Lock {

    void lock();

    void unlock();

    boolean tryLock();

    void lockInterruptibly() throws InterruptedException;

    boolean tryLock(long time , TimeUnit unit) throws InterruptedException;

    Condition newCondition();
}
