package com.bestcode.sourcecode.concurrent.locks;

import java.io.Serializable;

/**
 * @author xch
 * @version 1.00
 * @date 2017-12-28
 */
public abstract class AbstractOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = 9021110827818556035L;

    protected AbstractOwnableSynchronizer() { }

    private transient Thread exclusiveOwnerThread;

    public Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    public void setExclusiveOwnerThread(Thread exclusiveOwnerThread) {
        this.exclusiveOwnerThread = exclusiveOwnerThread;
    }
}
