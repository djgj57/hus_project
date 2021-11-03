package io.hus.repository.cityRepo;

import io.hus.entity.cityEntity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "from City c where c.status = 'CREATED'", nativeQuery = false)
    public List<City> getCities();

    @Query(value = "from City c where c.name = :name", nativeQuery = false)
    public City getCityByName(String name);
}
