package io.hus.service.reservationService;

import io.hus.entity.reservationEntity.Reservation;

import java.util.Optional;

public interface ReservationService {

    public void createReservation(Reservation reservation);
    public Optional<Reservation> findReservationById(Long id);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservation(Reservation reservation);

}
