package io.hus.util;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import io.hus.service.categoryService.CategoryService;
import io.hus.service.cityService.CityService;
import io.hus.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserService userService;
    private final CategoryService categoryService;
    private final CityService cityService;

    @Override
    public void run(ApplicationArguments args) {

        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

        userService.saveUser(new User(null, "John", "Travolta", "john@gmail.com", "1234567",
                new ArrayList<>()));
        userService.saveUser(new User(null, "Will", "Smith", "will@gmail.com", "1234567",
                new ArrayList<>()));
        userService.saveUser(new User(null, "Jim", "Carry", "jim@gmail.com", "1234567", new ArrayList<>()));
        userService.saveUser(new User(null, "Arnold", "Schwarzenegger", "arnold@gmail.com",
                "1234567",
                new ArrayList<>()));

        userService.addRoleToUser("john@gmail.com", "ROLE_USER");
        userService.addRoleToUser("john@gmail.com", "ROLE_MANAGER");
        userService.addRoleToUser("will@gmail.com", "ROLE_MANAGER");
        userService.addRoleToUser("jim@gmail.com", "ROLE_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_SUPER_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_USER");

        categoryService.createCategory(new Category(null, "casas", "Alojamientos enteros", "https://cdn.pixabay.com/photo/2016/11/18/17/46/house-1836070_960_720.jpg",
                "CREATED", new Date()));
        categoryService.createCategory(new Category(null, "apartamentos", "Alojamiento de " +
                "lujo", "https://cdn.pixabay.com/photo/2016/11/21/15/09/apartments-1845884_960_720.jpg",
                "CREATED", new Date()));
        categoryService.createCategory(new Category(null, "fincas", "Alojamientos en la " +
                "naturaleza", "https://cdn.pixabay.com/photo/2020/03/13/14/29/colombia-4928031_960_720.jpg",
                "CREATED", new Date()));
        categoryService.createCategory(new Category(null, "mansiones", "Alojamientos con " +
                "estilo", "https://cdn.pixabay.com/photo/2020/05/02/11/51/castle-5121096_960_720.jpg",
                "CREATED", new Date()));


        cityService.createCity(new City(null,"Cartagena","Colombia","CREATED",new Date()));
        cityService.createCity(new City(null,"Bogotá","Colombia","CREATED",new Date()));
        cityService.createCity(new City(null,"Medellin","Colombia","CREATED",new Date()));
        cityService.createCity(new City(null,"Cali","Colombia","CREATED",new Date()));
        cityService.createCity(new City(null,"Barranquilla","Colombia","CREATED",new Date()));
        cityService.createCity(new City(null,"Buenos Aires","Argentina","CREATED",new Date()));
        cityService.createCity(new City(null,"Córdoba","Argentina","CREATED",new Date()));
        cityService.createCity(new City(null,"Rosario","Argentina","CREATED",new Date()));
    }
}



