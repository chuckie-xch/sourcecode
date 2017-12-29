package com.bestcode.sourcecode.concurrent.locks;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author xch
 * @version 1.00
 * @date 2017-12-29
 */
public class ReentrantLock implements Lock, Serializable {
    private static final long serialVersionUID = 1442868322022448705L;

    private final Sync sync;

    public ReentrantLock() {
        sync = new NonFairSyc();
    }

    abstract static class Sync extends AbstractQueuedSynchronizer {

        abstract void lock();

        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                }
            } else if (current == getExclusiveOwnerThread()) {
                int nextState = state + acquires;
                if (nextState < 0) {
                    throw new Error("Maxium lock count exceeded");
                }
                setState(nextState);
                return true;
            }
            return false;
        }
    }



    static final class NonFairSyc extends Sync {
        private static final long serialVersionUID = -1374199413133546185L;
        @Override
        final void lock() {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }

        @Override
        protected final boolean tryAcquire(int acquires) {
            return nonfairTryAcquire(acquires);
        }
    }

    public void lock() {

    }

    public void unlock() {

    }

    public boolean tryLock() {
        return false;
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public Condition newCondition() {
        return null;
    }
}
