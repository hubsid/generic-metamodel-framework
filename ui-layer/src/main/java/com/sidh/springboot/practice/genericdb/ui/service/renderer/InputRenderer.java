package com.sidh.springboot.practice.genericdb.ui.service.renderer;

public interface InputRenderer<T> {
    String render(T render);
}