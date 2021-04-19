package com.facultate.evstud.repository;

import com.facultate.evstud.model.ResolvedSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolvedSheetRepository extends JpaRepository<ResolvedSheet, Long> {
}
