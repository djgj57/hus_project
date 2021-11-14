package io.hus.repository.reservationService;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.productEntity.Product;
import io.hus.entity.reservationEntity.Reservation;
import io.hus.entity.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByUser(User user);

    //find by userId
    // Count by title
    @Query(value = "select r from Reservation r where r.product.id = ?1")
    public List<Reservation> findByProductId(Long productId);
}
