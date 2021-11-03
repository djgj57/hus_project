package io.hus.service.cityService;

import io.hus.entity.cityEntity.City;
import io.hus.repository.cityRepo.CityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{
    final static Logger log = Logger.getLogger(CityServiceImpl.class);

    private final CityRepository cityRepository;

    @Override
    public List<City> listAllCity() {
        return cityRepository.getCities();
    }

    @Override
    public Optional<City> getCity(Long id){
        return cityRepository.findById(id);
    }

    @Override
    public City createCity(City city) {
        log.info("Saving new city: " + city.getName() + " to the database");
        city.setStatus("CREATED");
        city.setCreateAt(new Date());
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) {
        Optional<City> cityDB = cityRepository.findById(city.getId());
        if (cityDB.isPresent()) {
            log.info("Update city: " + city.getName());
            return cityRepository.save(city);
        }else{
            log.error("City not found in the database");
            return null;
        }
    }

    @Override
    public City deleteCity(Long id) {
        Optional<City> cityDB = cityRepository.findById(id);
        if (cityDB.isPresent()) {
            cityDB.get().setStatus("DELETED");
            log.info("Delete city with id " + id);
            return cityRepository.save(cityDB.get());
        }else {
            log.error("City not found in the database");
            return null;
        }
    }

    public City getCityByName(String name){
        return cityRepository.getCityByName(name);
    }
}
