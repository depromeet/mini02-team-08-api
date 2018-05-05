package com.depromeet.donkey.domain.donkey.repository;

import com.depromeet.donkey.domain.donkey.Area;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Integer> {
  Optional<Area> findAreaBySiAndGuAndDong(String si, String gu, String dong);
}

