package com.masiv.primeprinter.adapter.stream.impl;

import com.masiv.primeprinter.adapter.stream.OutputBinding;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StandardOutputBinding implements OutputBinding {

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
