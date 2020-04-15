package com.wgcisotto.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Passenger {

    private String name;
    private boolean vip;

}
