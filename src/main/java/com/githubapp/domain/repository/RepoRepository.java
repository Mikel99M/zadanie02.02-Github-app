package com.githubapp.domain.repository;

import com.githubapp.domain.model.Repo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface RepoRepository extends Repository<Repo, Long> {

    @Query("SELECT r FROM Repo r")
    List<Repo> findAll(Pageable pageable);

    @Query("SELECT r FROM Repo r WHERE r.id = :id")
    Optional<Repo> findById(Long id);

    Repo save(Repo repo);

    @Modifying
    @Query("UPDATE Repo r SET r.name = :#{#newRepo.name}, r.owner = :#{#newRepo.owner} WHERE r.id = :id")
    void updateById(Long id, Repo newRepo);

    @Modifying
    @Query("DELETE FROM Repo r WHERE r.id = :id")
    void deleteById(Long id);

}
