package APIApp.repository;

import APIApp.model.InquirySummary;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MySqlRepository extends JpaRepository<InquirySummary, Integer> {
    
}
