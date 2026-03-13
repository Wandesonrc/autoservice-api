package com.autoservice.api.autoservice.service;

public interface ConverteTo<T, A> {

    A converteToBack(T t);
    T converteToFront(A a);


}
