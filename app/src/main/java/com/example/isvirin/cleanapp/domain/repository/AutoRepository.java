package com.example.isvirin.cleanapp.domain.repository;

import com.example.isvirin.cleanapp.domain.model.Auto;

import java.util.List;

import rx.Observable;

public interface AutoRepository {
    Observable<List<Auto>> autos();
}
