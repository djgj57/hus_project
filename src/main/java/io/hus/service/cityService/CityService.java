package io.hus.service.cityService;

import io.hus.entity.cityEntity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    public List<City> listAllCity();
    public Optional<City> getCity(Long id);
    public City createCity(City city);
    public City updateCity(City city);
    public City deleteCity(Long id);

    public City getCityByName(String name);
}
