package com.kissszabo.hu.mmmweb.repository;

import com.kissszabo.hu.mmmweb.entity.Massage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface MassageRepository extends JpaRepository<Massage, Long> {
    Massage findMassageByName(String name);
}