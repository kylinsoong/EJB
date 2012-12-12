package com.kylin.ejb.remote.stateful;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(CounterService.class)
@Local(CounterServiceLocal.class)
public class CounterSession implements CounterServiceLocal {

    private int count = 100;

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }
}
