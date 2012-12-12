package com.kylin.ejb.remote.stateful;

public interface CounterService {

    void increment();

    void decrement();

    int getCount();
}
