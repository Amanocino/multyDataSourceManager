package com.amanoisuno.dynamicdatasource;

import org.springframework.stereotype.Service;

@Service
public class interfaceFileSonImpl extends interfaceFileImpl{
    @Override
    public void testInterface(String test1) {
        System.out.println("hello son!");
    }
}
