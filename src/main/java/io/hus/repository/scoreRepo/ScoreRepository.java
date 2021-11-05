package io.hus.repository.scoreRepo;


import io.hus.entity.scoreEntity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = "SELECT round(avg(score),1) as score FROM hus_db.tlb_scores where product_id =" +
            " ?1",
            nativeQuery = true)
    public double getScore(Long productId);


}
