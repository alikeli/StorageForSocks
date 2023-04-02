package com.project.storageforsocks.repository;

import com.project.storageforsocks.entity.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Integer> {

    Optional<Socks> findByColorAndCottonPart(String color, Integer cottonPart);


    List<Socks> findAllByColorAndCottonPartLessThan(String color, Integer cottonPart);
    List<Socks> findAllByColorAndCottonPartEquals(String color, Integer cottonPart);
    List<Socks> findAllByColorAndCottonPartGreaterThan(String color, Integer cottonPart);
}
