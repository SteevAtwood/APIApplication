package APIApp.repository;

import APIApp.model.InquirySummary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<InquirySummary, Integer> {

    Optional<InquirySummary> findByPassword(String password);

}
