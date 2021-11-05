package io.hus.util;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.featureEntity.Feature;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.productEntity.Product;
import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import io.hus.service.categoryService.CategoryService;
import io.hus.service.cityService.CityService;
import io.hus.service.featureService.FeatureService;
import io.hus.service.imageService.ImageService;
import io.hus.service.productService.ProductService;
import io.hus.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ImageService imageService;
    private final CityService cityService;
    private final FeatureService featureService;
    private final ProductService productService;

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

        Category category1 =  categoryService.createCategory(new Category(null, "casas",
                "Alojamientos " +
                "enteros",
                 "https://cdn.pixabay.com/photo/2016/11/18/17/46/house-1836070_960_720.jpg",
                "CREATED", new Date()));
        Category category2 =  categoryService.createCategory(new Category(null, "apartamentos",
                "Alojamiento de " +
                "lujo", "https://cdn.pixabay.com/photo/2016/11/21/15/09/apartments-1845884_960_720.jpg",
                "CREATED", new Date()));
        Category category3 =   categoryService.createCategory(new Category(null, "fincas",
                "Alojamientos en la " +
                "naturaleza", "https://cdn.pixabay.com/photo/2020/03/13/14/29/colombia-4928031_960_720.jpg",
                "CREATED", new Date()));
        Category category4 =  categoryService.createCategory(new Category(null, "mansiones",
                "Alojamientos con " +
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
        String url11 = "https://cdn.pixabay.com/photo/2016/11/18/17/20/living-room" +
                "-1835923_960_720" +
                ".jpg";
        String url12 = "https://cdn.pixabay.com/photo/2016/10/13/09/08/travel-1737171_960_720.jpg";
        String url13 = "https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336167_960_720" +
                ".jpg";
        String url14 = "https://cdn.pixabay.com/photo/2015/10/20/18/57/furniture-998265_960_720" +
                ".jpg";
        String url15 = "https://cdn.pixabay.com/photo/2017/09/09/18/25/living-room" +
                "-2732939_960_720.jpg";
        String url16 = "https://cdn.pixabay.com/photo/2017/03/22/17/39/kitchen-2165756_960_720.jpg";
        String url17 = "https://cdn.pixabay.com/photo/2017/08/27/10/16/interior-2685521_960_720" +
                ".jpg";
        String url18 = "https://cdn.pixabay.com/photo/2017/08/02/01/01/living-room" +
                "-2569325_960_720.jpg";
        String url19 = "https://cdn.pixabay.com/photo/2016/04/18/08/50/kitchen-1336160_960_720.jpg";
        String url20 = "https://cdn.pixabay.com/photo/2017/07/09/03/19/home-2486092_960_720.jpg";
        String url21 = "https://cdn.pixabay.com/photo/2016/11/18/17/20/living-room" +
                "-1835923_960_720" +
                ".jpg";
        String url22 = "https://cdn.pixabay.com/photo/2016/10/13/09/08/travel-1737171_960_720.jpg";
        String url23 = "https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336167_960_720" +
                ".jpg";
        String url24 = "https://cdn.pixabay.com/photo/2015/10/20/18/57/furniture-998265_960_720" +
                ".jpg";
        String url25 = "https://cdn.pixabay.com/photo/2017/09/09/18/25/living-room" +
                "-2732939_960_720.jpg";
        String url26 = "https://cdn.pixabay.com/photo/2017/03/22/17/39/kitchen-2165756_960_720.jpg";
        String url27 = "https://cdn.pixabay.com/photo/2017/08/27/10/16/interior-2685521_960_720" +
                ".jpg";
        String url28 = "https://cdn.pixabay.com/photo/2017/08/02/01/01/living-room" +
                "-2569325_960_720.jpg";
        String url29 = "https://cdn.pixabay.com/photo/2016/04/18/08/50/kitchen-1336160_960_720.jpg";
        String url30 = "https://cdn.pixabay.com/photo/2017/07/09/03/19/home-2486092_960_720.jpg";
        String url31 = "https://cdn.pixabay.com/photo/2016/11/18/17/20/living-room" +
                "-1835923_960_720" +
                ".jpg";
        String url32 = "https://cdn.pixabay.com/photo/2016/10/13/09/08/travel-1737171_960_720.jpg";
        String url33 = "https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336167_960_720" +
                ".jpg";
        String url34 = "https://cdn.pixabay.com/photo/2015/10/20/18/57/furniture-998265_960_720" +
                ".jpg";
        String url35 = "https://cdn.pixabay.com/photo/2017/09/09/18/25/living-room" +
                "-2732939_960_720.jpg";
        String url36 = "https://cdn.pixabay.com/photo/2017/03/22/17/39/kitchen-2165756_960_720.jpg";
        String url37 = "https://cdn.pixabay.com/photo/2017/08/27/10/16/interior-2685521_960_720" +
                ".jpg";
        String url38 = "https://cdn.pixabay.com/photo/2017/08/02/01/01/living-room" +
                "-2569325_960_720.jpg";
        String url39 = "https://cdn.pixabay.com/photo/2016/04/18/08/50/kitchen-1336160_960_720.jpg";
        String url40 = "https://cdn.pixabay.com/photo/2017/07/09/03/19/home-2486092_960_720.jpg";
        String url41 = "https://cdn.pixabay.com/photo/2016/11/18/17/20/living-room" +
                "-1835923_960_720" +
                ".jpg";
        String url42 = "https://cdn.pixabay.com/photo/2016/10/13/09/08/travel-1737171_960_720.jpg";
        String url43 = "https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336167_960_720" +
                ".jpg";
        String url44 = "https://cdn.pixabay.com/photo/2015/10/20/18/57/furniture-998265_960_720" +
                ".jpg";
        String url45 = "https://cdn.pixabay.com/photo/2017/09/09/18/25/living-room" +
                "-2732939_960_720.jpg";
        String url46 = "https://cdn.pixabay.com/photo/2017/03/22/17/39/kitchen-2165756_960_720.jpg";
        String url47 = "https://cdn.pixabay.com/photo/2017/08/27/10/16/interior-2685521_960_720" +
                ".jpg";
        String url48 = "https://cdn.pixabay.com/photo/2017/08/02/01/01/living-room" +
                "-2569325_960_720.jpg";
        String url49 = "https://cdn.pixabay.com/photo/2016/04/18/08/50/kitchen-1336160_960_720.jpg";
        String url50 = "https://cdn.pixabay.com/photo/2017/07/09/03/19/home-2486092_960_720.jpg";

        Image image1 = imageService.createImage(new Image(null, "foto 1", url1, new Date()));
        Image image2 = imageService.createImage(new Image(null, "foto 2", url2, new Date()));
        Image image3 = imageService.createImage(new Image(null, "foto 3", url3, new Date()));
        Image image4 = imageService.createImage(new Image(null, "foto 4", url4, new Date()));
        Image image5 =  imageService.createImage(new Image(null, "foto 5", url5, new Date()));
        Image image6 =  imageService.createImage(new Image(null, "foto 6", url6, new Date()));
        Image image7 =    imageService.createImage(new Image(null, "foto 7", url7, new Date()));
        Image image8 =    imageService.createImage(new Image(null, "foto 8", url8, new Date()));
        Image image9 =    imageService.createImage(new Image(null, "foto 9", url9, new Date()));
        Image image10 =    imageService.createImage(new Image(null, "foto 10", url10, new Date()));
        Image image11 =    imageService.createImage(new Image(null, "foto 11", url11, new Date()));
        Image image12 =    imageService.createImage(new Image(null, "foto 12", url12, new Date()));
        Image image13 =    imageService.createImage(new Image(null, "foto 13", url13, new Date()));
        Image image14 =    imageService.createImage(new Image(null, "foto 14", url14, new Date()));
        Image image15 =    imageService.createImage(new Image(null, "foto 15", url15, new Date()));
        Image image16 =    imageService.createImage(new Image(null, "foto 16", url16, new Date()));
        Image image17 =    imageService.createImage(new Image(null, "foto 17", url17, new Date()));
        Image image18 =    imageService.createImage(new Image(null, "foto 18", url18, new Date()));
        Image image19 =    imageService.createImage(new Image(null, "foto 19", url19, new Date()));
        Image image20 =    imageService.createImage(new Image(null, "foto 20", url20, new Date()));
        Image image21 =    imageService.createImage(new Image(null, "foto 21", url21, new Date()));
        Image image22 =    imageService.createImage(new Image(null, "foto 22", url22, new Date()));
        Image image23 =    imageService.createImage(new Image(null, "foto 23", url23, new Date()));
        Image image24 =    imageService.createImage(new Image(null, "foto 24", url24, new Date()));
        Image image25 =    imageService.createImage(new Image(null, "foto 25", url25, new Date()));
        Image image26 =    imageService.createImage(new Image(null, "foto 26", url26, new Date()));
        Image image27 =    imageService.createImage(new Image(null, "foto 27", url27, new Date()));
        Image image28 =    imageService.createImage(new Image(null, "foto 28", url28, new Date()));
        Image image29 =    imageService.createImage(new Image(null, "foto 29", url29, new Date()));
        Image image30 =    imageService.createImage(new Image(null, "foto 30", url30, new Date()));
        Image image31 =    imageService.createImage(new Image(null, "foto 31", url31, new Date()));
        Image image32 =    imageService.createImage(new Image(null, "foto 32", url32, new Date()));
        Image image33 =    imageService.createImage(new Image(null, "foto 33", url33, new Date()));
        Image image34 =    imageService.createImage(new Image(null, "foto 34", url34, new Date()));
        Image image35 =    imageService.createImage(new Image(null, "foto 35", url35, new Date()));
        Image image36 =    imageService.createImage(new Image(null, "foto 36", url36, new Date()));
        Image image37 =    imageService.createImage(new Image(null, "foto 37", url37, new Date()));
        Image image38 =    imageService.createImage(new Image(null, "foto 38", url38, new Date()));
        Image image39 =    imageService.createImage(new Image(null, "foto 39", url39, new Date()));
        Image image40 =    imageService.createImage(new Image(null, "foto 40", url40, new Date()));
        Image image41 =    imageService.createImage(new Image(null, "foto 41", url41, new Date()));
        Image image42 =    imageService.createImage(new Image(null, "foto 42", url42, new Date()));
        Image image43 =    imageService.createImage(new Image(null, "foto 43", url43, new Date()));
        Image image44 =    imageService.createImage(new Image(null, "foto 44", url44, new Date()));
        Image image45 =    imageService.createImage(new Image(null, "foto 45", url45, new Date()));
        Image image46 =    imageService.createImage(new Image(null, "foto 46", url46, new Date()));
        Image image47 =    imageService.createImage(new Image(null, "foto 47", url47, new Date()));
        Image image48 =    imageService.createImage(new Image(null, "foto 48", url48, new Date()));
        Image image49 =    imageService.createImage(new Image(null, "foto 49", url49, new Date()));
        Image image50 =    imageService.createImage(new Image(null, "foto 50", url50, new Date()));



        /* -------- cities loading -------- */

        City city1 = cityService.createCity(new City(null,"Cartagena","Colombia","CREATED",
                new Date()));
        City city2 =  cityService.createCity(new City(null,"Bogotá","Colombia","CREATED",
                new Date()));
        City city3 =  cityService.createCity(new City(null,"Medellin","Colombia","CREATED",
                new Date()));
        City city4 =  cityService.createCity(new City(null,"Cali","Colombia","CREATED",new Date()));
        City city5 =  cityService.createCity(new City(null,"Barranquilla","Colombia","CREATED",
                new Date()));
        City city6 =  cityService.createCity(new City(null,"Buenos Aires","Argentina","CREATED",
                new Date()));
        City city7 =  cityService.createCity(new City(null,"Córdoba","Argentina","CREATED",
                new Date()));
        City city8 = cityService.createCity(new City(null,"Rosario","Argentina","CREATED",
                new Date()));

        /* -------- features loading -------- */

        String featureName1 = "Aire acondicionado";
        String featureIcon1 = "FaSnowflake";

        String featureName2 = "Agua caliente";
        String featureIcon2 = "FaFire";

        String featureName3 = "Jacuzzi";
        String featureIcon3 = "FaHotTub";

        String featureName4 = "Area para trabajar";
        String featureIcon4 = "FaLaptopHouse";

        String featureName5 = "Electrodomesticos cocina";
        String featureIcon5 = "FaBlender";

        String featureName6 = "Articulos basicos cocina";
        String featureIcon6 = "FaUtensils";

        String featureName7 = "Botiquín";
        String featureIcon7 = "FaBriefcaseMedical";

        String featureName8 = "Cafetera";
        String featureIcon8 = "FaMugHot";

        String featureName9 = "Calefaccion";
        String featureIcon9 = "FaTemperatureHigh";

        String featureName10 = "Wifi";
        String featureIcon10 = "FaWifi";

        String featureName11 = "Mascotas permitidas";
        String featureIcon11 = "FaPaw";

        String featureName12 = "Piscina";
        String featureIcon12 = "FaSwimmingPool";

        String featureName13 = "TV";
        String featureIcon13 = "FaTv";

        String featureName14 = "Elementos basicos";
        String featureIcon14 = "FaToiletPaper";

        String featureName15 = "Camara de seguridad";
        String featureIcon15 = "FaVideo";

        String featureName16 = "Cerradura inteligente";
        String featureIcon16 = "FaFingerprint";

        String featureName17 = "Equipo ejercicio";
        String featureIcon17 = "FaDumbbell";

        String featureName18 = "Estacionamiento Pago afuera";
        String featureIcon18 = "FaParking";

        String featureName19 = "Estacionamiento gratuito dentro";
        String featureIcon19 = "FaCar";

        String featureName20 = "Extintor";
        String featureIcon20 = "FaFireExtinguisher";

        String featureName21 = "Contenedor reciclable";
        String featureIcon21 = "FaRecycle";

        Feature feature1 =  featureService.createFeature(new Feature(null, featureName1,
                featureIcon1, new Date()));
        Feature feature2 =  featureService.createFeature(new Feature(null, featureName2,
                featureIcon2, new Date()));
        Feature feature3 =  featureService.createFeature(new Feature(null, featureName3,
                featureIcon3, new Date()));
        Feature feature4 =   featureService.createFeature(new Feature(null, featureName4,
                featureIcon4, new Date()));
        Feature feature5 =  featureService.createFeature(new Feature(null, featureName5,
                featureIcon5, new Date()));
        Feature feature6 =   featureService.createFeature(new Feature(null, featureName6,
                featureIcon6, new Date()));
        Feature feature7 =   featureService.createFeature(new Feature(null, featureName7,
                featureIcon7, new Date()));
        Feature feature8 =   featureService.createFeature(new Feature(null, featureName8,
                featureIcon8, new Date()));
        Feature feature9 =   featureService.createFeature(new Feature(null, featureName9,
                featureIcon9, new Date()));
        Feature feature10 =   featureService.createFeature(new Feature(null, featureName10,
                featureIcon10, new Date()));
        Feature feature11 =    featureService.createFeature(new Feature(null, featureName11,
                featureIcon11, new Date()));
        Feature feature12 =    featureService.createFeature(new Feature(null, featureName12,
                featureIcon12, new Date()));
        Feature feature13 =   featureService.createFeature(new Feature(null, featureName13,
                featureIcon13, new Date()));
        Feature feature14 =   featureService.createFeature(new Feature(null, featureName14,
                featureIcon14, new Date()));
        Feature feature15 =   featureService.createFeature(new Feature(null, featureName15,
                featureIcon15, new Date()));
        Feature feature16 =   featureService.createFeature(new Feature(null, featureName16,
                featureIcon16, new Date()));
        Feature feature17 =    featureService.createFeature(new Feature(null, featureName17,
                featureIcon17, new Date()));
        Feature feature18 =   featureService.createFeature(new Feature(null, featureName18,
                featureIcon18, new Date()));
        Feature feature19 =   featureService.createFeature(new Feature(null, featureName19,
                featureIcon19, new Date()));
        Feature feature20 =   featureService.createFeature(new Feature(null, featureName20,
                featureIcon20, new Date()));
        Feature feature21 =  featureService.createFeature(new Feature(null, featureName21,
                featureIcon21, new Date()));

        /* -------- product loading -------- */

        Product product1 = Product.builder()
                .id(null)
                .name("Casa en Cartagena")
                .description("Casa en Cartagena")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image1, image2, image3, image4, image5, image6, image7))
                .category(category1)
                .city(city1)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(4.0).build();
        productService.createProduct(product1);

        Product product2 = Product.builder()
                .id(null)
                .name("Casa en Bogota")
                .description("Hermosa casa con vistas a la montana")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20, feature12))
                .images(Set.of(image8, image9, image10, image11, image12, image13, image14))
                .category(category2)
                .city(city2)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(3.5).build();
        productService.createProduct(product2);

        Product product3 = Product.builder()
                .id(null)
                .name("Casa en Medellin")
                .description("Otra descripcion")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image15, image16, image17, image18, image19, image20, image21))
                .category(category3)
                .city(city3)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product3);

        Product product4 = Product.builder()
                .id(null)
                .name("Casa en la loma de Medellin")
                .description("Otra descripcion")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image22, image23, image24))
                .category(category4)
                .city(city3)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product4);

        Product product5 = Product.builder()
                .id(null)
                .name("Casa en Buenos aires")
                .description("Otra descripcion")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image25))
                .category(category1)
                .city(city6)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product5);

        Product product6 = Product.builder()
                .id(null)
                .name("Casa en Buenos aires")
                .description("Otra descripcion")
                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
                .images(Set.of(image26, image27, image28, image29, image30, image31, image32))
                .category(category2)
                .city(city5)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product6);

        Product product7 = Product.builder()
                .id(null)
                .name("Casa en Cartagena de nuevo")
                .description("Casa en Cartagena de nuevo")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image33))
                .category(category1)
                .city(city1)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(4.0).build();
        productService.createProduct(product7);

        Product product8 = Product.builder()
                .id(null)
                .name("Casa en Bogota de neuvo")
                .description("Hermosa casa con vistas a la montana de neuvo")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20, feature12))
                .images(Set.of(image34))
                .category(category2)
                .city(city2)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(3.5).build();
        productService.createProduct(product8);

        Product product9 = Product.builder()
                .id(null)
                .name("Casa en Medellin de nuevo")
                .description("Otra descripcion de nuevo")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image35))
                .category(category3)
                .city(city3)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product9);

        Product product10 = Product.builder()
                .id(null)
                .name("Casa en la loma de Medellin de neuvo")
                .description("Otra descripcion de neuvo")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image36))
                .category(category4)
                .city(city3)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product10);

        Product product11 = Product.builder()
                .id(null)
                .name("Casa en Buenos aires de nuevo")
                .description("Otra descripcion")
                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
                .images(Set.of(image37))
                .category(category1)
                .city(city6)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product11);

        Product product12 = Product.builder()
                .id(null)
                .name("Casa en Buenos aires")
                .description("Otra descripcion")
                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
                .images(Set.of(image38))
                .category(category2)
                .city(city5)
                .latitude(10.3977)
                .longitude(-75.567)
                .score(5.0).build();
        productService.createProduct(product12);



    }
}



