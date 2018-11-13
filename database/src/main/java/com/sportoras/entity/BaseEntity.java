package com.sportoras.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<P> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private P id;
}
