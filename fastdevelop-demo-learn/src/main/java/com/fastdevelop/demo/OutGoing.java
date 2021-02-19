package com.fastdevelop.demo;

import java.util.function.Consumer;

public class OutGoing<T> {

    private T t;

    public OutGoing(T t) {
        this.t = t;
    }

    public OutGoing when(Boolean expression) {
        if (!expression)
        {
            throw new RuntimeException("");
        }
        return this;
    }


    public  OutGoing<T> then(Consumer<T> tConsumer) {
        tConsumer.accept(t);
        return this;
    }


    public static void main(String[] args) {
        OutGoing<String> og = new OutGoing<>("dd");
        og.when(1>0).then(o -> {

        });
    }

}
