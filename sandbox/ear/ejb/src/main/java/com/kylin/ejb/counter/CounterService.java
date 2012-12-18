package com.kylin.ejb.counter;

public interface CounterService {

    void increment();

    void decrement();

    int getCount();
}
