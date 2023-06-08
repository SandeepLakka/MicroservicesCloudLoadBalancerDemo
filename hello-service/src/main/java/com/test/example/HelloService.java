package com.test.example;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class HelloService {

    private AtomicLong counter = new AtomicLong();


    public long getCounterValue() {
        return this.counter.get();
    }

    public long increment() {
        return counter.incrementAndGet();
    }

    public long decrement() {
        return counter.decrementAndGet();
    }
}
