package io.hus.util;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import io.hus.service.categoryService.CategoryService;
import io.hus.service.imageService.ImageService;
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
    private final ImageService imageService;

    @Override
    public void run(ApplicationArguments args) {

        /* -------- role loading -------- */

        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

        /* -------- user loading -------- */

        userService.saveUser(new User(null, "John", "Travolta", "john@gmail.com", "1234567",
                new ArrayList<>()));
        userService.saveUser(new User(null, "Will", "Smith", "will@gmail.com", "1234567",
                new ArrayList<>()));
        userService.saveUser(new User(null, "Jim", "Carry", "jim@gmail.com", "1234567", new ArrayList<>()));
        userService.saveUser(new User(null, "Arnold", "Schwarzenegger", "arnold@gmail.com",
                "1234567",
                new ArrayList<>()));

        /* -------- adding roles to users -------- */

        userService.addRoleToUser("john@gmail.com", "ROLE_USER");
        userService.addRoleToUser("john@gmail.com", "ROLE_MANAGER");
        userService.addRoleToUser("will@gmail.com", "ROLE_MANAGER");
        userService.addRoleToUser("jim@gmail.com", "ROLE_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_SUPER_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_USER");

        /* -------- category loading -------- */

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

        /* -------- image loading -------- */

        String url1 = "https://cdn.pixabay.com/photo/2016/11/18/17/20/living-room-1835923_960_720" +
                ".jpg";
        String url2 = "https://cdn.pixabay.com/photo/2016/10/13/09/08/travel-1737171_960_720.jpg";
        String url3 = "https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336167_960_720.jpg";
        String url4 = "https://cdn.pixabay.com/photo/2015/10/20/18/57/furniture-998265_960_720.jpg";
        String url5 = "https://cdn.pixabay.com/photo/2017/09/09/18/25/living-room-2732939_960_720.jpg";
        String url6 = "https://cdn.pixabay.com/photo/2017/03/22/17/39/kitchen-2165756_960_720.jpg";
        String url7 = "https://cdn.pixabay.com/photo/2017/08/27/10/16/interior-2685521_960_720.jpg";
        String url8 = "https://cdn.pixabay.com/photo/2017/08/02/01/01/living-room-2569325_960_720.jpg";
        String url9 = "https://cdn.pixabay.com/photo/2016/04/18/08/50/kitchen-1336160_960_720.jpg";
        String url10 = "https://cdn.pixabay.com/photo/2017/07/09/03/19/home-2486092_960_720.jpg";

        imageService.createImage(new Image(null, "foto 1", url1, new Date()));
        imageService.createImage(new Image(null, "foto 2", url2, new Date()));
        imageService.createImage(new Image(null, "foto 3", url3, new Date()));
        imageService.createImage(new Image(null, "foto 4", url4, new Date()));
        imageService.createImage(new Image(null, "foto 5", url5, new Date()));
        imageService.createImage(new Image(null, "foto 6", url6, new Date()));
        imageService.createImage(new Image(null, "foto 7", url7, new Date()));
        imageService.createImage(new Image(null, "foto 8", url8, new Date()));
        imageService.createImage(new Image(null, "foto 9", url9, new Date()));
        imageService.createImage(new Image(null, "foto 10", url10, new Date()));

    }
}



