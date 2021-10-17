package com.mobile.bean;

import lombok.Data;

@Data
public class ExamineeSubject {
    private Integer id;

    private Integer eid;

    private Examinee examinee;

    private Integer subject;

    private Subject s;

    private Integer building;

    private Building b;

    private Integer room;

    private Integer seat;
}