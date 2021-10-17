package com.mobile.bean;

import lombok.Data;

@Data
public class Road {
    private Integer id;

    private Integer startPk;

    private KeyPoint startKeyPoint;

    private Integer endPk;

    private KeyPoint endKeyPoint;

    private Integer rbuilding;
}