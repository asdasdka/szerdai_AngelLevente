package com.teszta.tesztaapp.repository;

import com.teszta.tesztaapp.model.Teszta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesztaRepository extends JpaRepository<Teszta, Integer> {
}
