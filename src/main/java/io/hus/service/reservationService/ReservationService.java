package io.hus.service.reservationService;

import io.hus.entity.productEntity.Product;
import io.hus.entity.reservationEntity.Reservation;
import io.hus.entity.userEntity.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public Reservation createReservation(Reservation reservation);
    public Optional<Reservation> findReservationById(Long id);
    public void deleteReservation(Reservation reservation);
    public List<Reservation> findByUser(User user);
    public List<Reservation> findByProductId(Long productId);
}
