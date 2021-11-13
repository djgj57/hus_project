package io.hus.util;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.featureEntity.Feature;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.productEntity.Product;
import io.hus.entity.reservationEntity.Reservation;
import io.hus.entity.scoreEntity.Score;
import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import io.hus.service.categoryService.CategoryService;
import io.hus.service.cityService.CityService;
import io.hus.service.featureService.FeatureService;
import io.hus.service.imageService.ImageService;
import io.hus.service.productService.ProductService;
import io.hus.service.scoreService.ScoreService;
import io.hus.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ImageService imageService;
    private final CityService cityService;
    private final FeatureService featureService;
    private final ProductService productService;
    private final ScoreService scoreService;

    @Override
    public void run(ApplicationArguments args) {

        /* -------- role loading -------- */

        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

        /* -------- user loading -------- */


        userService.saveUser(new User(null, "John", "Travolta", "john@gmail.com", "1234567",
                new ArrayList<>(), true, Collections.emptySet()));

        userService.saveUser(new User(null, "Will", "Smith", "will@gmail.com", "1234567",
                new ArrayList<>(), true, Collections.emptySet()));

        userService.saveUser(new User(null, "Jim", "Carry", "jim@gmail.com", "1234567", new ArrayList<>(), true, Collections.emptySet()));

        userService.saveUser(new User(null, "Arnold", "Schwarzenegger", "arnold@gmail.com",
                "1234567",
                new ArrayList<>(), true, Collections.emptySet()));

        userService.saveUser(new User(null, "Bruce", "Willis", "bruce@gmail.com", "1234567", new ArrayList<>(), true, Collections.emptySet()));

        /* -------- adding roles to users -------- */
        userService.addRoleToUser("bruce@gmail.com", "ROLE_USER");
        userService.addRoleToUser("john@gmail.com", "ROLE_USER");
        userService.addRoleToUser("john@gmail.com", "ROLE_MANAGER");
        userService.addRoleToUser("will@gmail.com", "ROLE_MANAGER");
        userService.addRoleToUser("jim@gmail.com", "ROLE_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_SUPER_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_ADMIN");
        userService.addRoleToUser("arnold@gmail.com", "ROLE_USER");

//        /* -------- category loading -------- */
//
//        Category category1 = categoryService.createCategory(new Category(null, "casas",
//                "Casas con todas las comodidades necesarias",
//                "https://s3-img-urls.s3.amazonaws.com/house-1836070_960_720.jpg",
//                "CREATED", new Date()));
//        Category category2 = categoryService.createCategory(new Category(null, "apartamentos",
//                "Lindos espacios para habitar solo o en compañía ", "https://s3-img-urls.s3.amazonaws.com/apartments-1845884_960_720.jpg",
//                "CREATED", new Date()));
//        Category category3 = categoryService.createCategory(new Category(null, "fincas",
//                "Conéctate con la naturaleza y disfruta hermosos paisajes", "https://s3-img-urls.s3.amazonaws.com/colombia-4928031_960_720.jpg",
//                "CREATED", new Date()));
//        Category category4 = categoryService.createCategory(new Category(null, "mansiones",
//                "Lugares maravillosos para pasar momentos inolvidables", "https://s3-img-urls.s3.amazonaws.com/castle-5121096_960_720.jpg",
//                "CREATED", new Date()));
//
//        /* -------- image loading -------- */
//
//        String url1 = "https://s3-img-urls.s3.amazonaws.com/abandoned-4456767_960_720.jpg";
//        String url2 = "https://s3-img-urls.s3.amazonaws.com/apartment-1835482_960_720.jpg";
//        String url3 = "https://s3-img-urls.s3.amazonaws.com/apartment-1851201_960_720.jpg";
//        String url4 = "https://s3-img-urls.s3.amazonaws.com/apartment-185779_960_720.jpg";
//        String url5 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094645_960_720.jpg";
//        String url6 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094660_960_720.jpg";
//        String url7 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094666_960_720.jpg";
//        String url8 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094689_960_720.jpg";
//        String url9 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094700__340.jpg";
//        String url10 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094702__340.jpg";
//        String url11 = "https://s3-img-urls.s3.amazonaws.com/apartment-406901_960_720.jpg";
//        String url12 = "https://s3-img-urls.s3.amazonaws.com/apartment-416039__340.jpg";
//        String url13 = "https://s3-img-urls.s3.amazonaws.com/apartment-lounge-3147892_960_720.jpg";
//        String url14 = "https://s3-img-urls.s3.amazonaws.com/apartments-1845884_960_720.jpg";
//        String url15 = "https://s3-img-urls.s3.amazonaws.com/architecture-2141045__340.jpg";
//        String url16 = "https://s3-img-urls.s3.amazonaws.com/architecture-2804083_960_720.jpg";
//        String url17 = "https://s3-img-urls.s3.amazonaws.com/architecture-5339245_960_720.jpg";
//        String url18 = "https://s3-img-urls.s3.amazonaws.com/bath-3622540__340.jpg";
//        String url19 = "https://s3-img-urls.s3.amazonaws.com/bathroom-2094733_960_720.jpg";
//        String url20 = "https://s3-img-urls.s3.amazonaws.com/bathroom-4032529__340.jpg";
//        String url21 = "https://s3-img-urls.s3.amazonaws.com/bathroom-6686057_960_720.jpg";
//        String url22 = "https://s3-img-urls.s3.amazonaws.com/bed-1834327_960_720.jpg";
//        String url23 = "https://s3-img-urls.s3.amazonaws.com/bed-1839183_960_720.jpg";
//        String url24 = "https://s3-img-urls.s3.amazonaws.com/bed-625386_960_720.jpg";
//        String url25 = "https://s3-img-urls.s3.amazonaws.com/bedroom-1285156_960_720.jpg";
//        String url26 = "https://s3-img-urls.s3.amazonaws.com/bedroom-1940169_960_720.jpg";
//        String url27 = "https://s3-img-urls.s3.amazonaws.com/bedroom-3778695_960_720.jpg";
//        String url28 = "https://s3-img-urls.s3.amazonaws.com/bedroom-389254_960_720.jpg";
//        String url29 = "https://s3-img-urls.s3.amazonaws.com/bedroom-416062_960_720.jpg";
//        String url30 = "https://s3-img-urls.s3.amazonaws.com/bedroom-490779_960_720.jpg";
//        String url31 = "https://s3-img-urls.s3.amazonaws.com/bedroom-5540924_960_720.jpg";
//        String url32 = "https://s3-img-urls.s3.amazonaws.com/bedroom-5686427__340.jpg";
//        String url33 = "https://s3-img-urls.s3.amazonaws.com/bedroom-6686058_960_720.jpg";
//        String url34 = "https://s3-img-urls.s3.amazonaws.com/bedroom-6686061_960_720.jpg";
//        String url35 = "https://s3-img-urls.s3.amazonaws.com/brick-wall-1834784_960_720.jpg";
//        String url36 = "https://s3-img-urls.s3.amazonaws.com/building-91228__340.jpg";
//        String url37 = "https://s3-img-urls.s3.amazonaws.com/castle-5121096_960_720.jpg";
//        String url38 = "https://s3-img-urls.s3.amazonaws.com/chair-2436892__340.jpg";
//        String url39 = "https://s3-img-urls.s3.amazonaws.com/chair-558951__340.jpg";
//        String url40 = "https://s3-img-urls.s3.amazonaws.com/chairs-2181947_960_720.jpg";
//        String url41 = "https://s3-img-urls.s3.amazonaws.com/chairs-2181960__340.jpg";
//        String url42 = "https://s3-img-urls.s3.amazonaws.com/chairs-2181968_960_720.jpg";
//        String url43 = "https://s3-img-urls.s3.amazonaws.com/colombia-4928031_960_720.jpg";
//        String url44 = "https://s3-img-urls.s3.amazonaws.com/contemporary-3077021_960_720.jpg";
//        String url45 = "https://s3-img-urls.s3.amazonaws.com/country-house-5019947_960_720.jpg";
//        String url46 = "https://s3-img-urls.s3.amazonaws.com/crib-890565_960_720.jpg";
//        String url47 = "https://s3-img-urls.s3.amazonaws.com/dining-room-1158266_960_720.jpg";
//        String url48 = "https://s3-img-urls.s3.amazonaws.com/dining-room-1476060_960_720.jpg";
//        String url49 = "https://s3-img-urls.s3.amazonaws.com/family-home-475879_960_720.jpg";
//        String url50 = "https://s3-img-urls.s3.amazonaws.com/fireplace-416042_960_720.jpg";
//        String url51 = "https://s3-img-urls.s3.amazonaws.com/furniture-2436880__340.jpg";
//        String url52 = "https://s3-img-urls.s3.amazonaws.com/furniture-998265_960_720.jpg";
//        String url53 = "https://s3-img-urls.s3.amazonaws.com/garlic-2556022_960_720.jpg";
//        String url54 = "https://s3-img-urls.s3.amazonaws.com/george-eastman-house-70173__340.jpg";
//        String url55 = "https://s3-img-urls.s3.amazonaws.com/ginsburgconstruction-kitchen-3-330737_960_720.jpg";
//        String url56 = "https://s3-img-urls.s3.amazonaws.com/hall-621741_960_720.jpg";
//        String url57 = "https://s3-img-urls.s3.amazonaws.com/holiday-house-186366_960_720.jpg";
//        String url58 = "https://s3-img-urls.s3.amazonaws.com/home-1622401_960_720.jpg";
//        String url59 = "https://s3-img-urls.s3.amazonaws.com/home-1680800_960_720.jpg";
//        String url60 = "https://s3-img-urls.s3.amazonaws.com/home-3593729_960_720.jpg";
//        String url61 = "https://s3-img-urls.s3.amazonaws.com/home-3593830__340.jpg";
//        String url62 = "https://s3-img-urls.s3.amazonaws.com/home-5003501_960_720.jpg";
//        String url63 = "https://s3-img-urls.s3.amazonaws.com/home-5526690_960_720.jpg";
//        String url64 = "https://s3-img-urls.s3.amazonaws.com/home-5526692__340.jpg";
//        String url65 = "https://s3-img-urls.s3.amazonaws.com/home-5526694__340.jpg";
//        String url66 = "https://s3-img-urls.s3.amazonaws.com/home-663226_960_720.jpg";
//        String url67 = "https://s3-img-urls.s3.amazonaws.com/house-1477041_960_720.jpg";
//        String url68 = "https://s3-img-urls.s3.amazonaws.com/house-1836070_960_720.jpg";
//        String url69 = "https://s3-img-urls.s3.amazonaws.com/house-2469067_960_720.jpg";
//        String url70 = "https://s3-img-urls.s3.amazonaws.com/house-2469110_960_720.jpg";
//        String url71 = "https://s3-img-urls.s3.amazonaws.com/house-2483336_960_720.jpg";
//        String url72 = "https://s3-img-urls.s3.amazonaws.com/house-3096523_960_720.jpg";
//        String url73 = "https://s3-img-urls.s3.amazonaws.com/house-4019638_960_720.jpg";
//        String url74 = "https://s3-img-urls.s3.amazonaws.com/house-6691124__340.jpg";
//        String url75 = "https://s3-img-urls.s3.amazonaws.com/indoor-4148893__340.jpg";
//        String url76 = "https://s3-img-urls.s3.amazonaws.com/indoors-3058658_960_720.jpg";
//        String url77 = "https://s3-img-urls.s3.amazonaws.com/indoors-3101776_960_720.jpg";
//        String url78 = "https://s3-img-urls.s3.amazonaws.com/interior-1026447_960_720.jpg";
//        String url79 = "https://s3-img-urls.s3.amazonaws.com/interior-1961070_960_720.jpg";
//        String url80 = "https://s3-img-urls.s3.amazonaws.com/interior-2400372_960_720.jpg";
//        String url81 = "https://s3-img-urls.s3.amazonaws.com/interior-2685518_960_720.jpg";
//        String url82 = "https://s3-img-urls.s3.amazonaws.com/interior-2685521_960_720.jpg";
//        String url83 = "https://s3-img-urls.s3.amazonaws.com/interior-3012218_960_720.jpg";
//        String url84 = "https://s3-img-urls.s3.amazonaws.com/interior-3531779_960_720.jpg";
//        String url85 = "https://s3-img-urls.s3.amazonaws.com/interior-3531796__340.jpg";
//        String url86 = "https://s3-img-urls.s3.amazonaws.com/interior-3539570__340.jpg";
//        String url87 = "https://s3-img-urls.s3.amazonaws.com/interior-3575815_960_720.jpg";
//        String url88 = "https://s3-img-urls.s3.amazonaws.com/interior-3575819_960_720.jpg";
//        String url89 = "https://s3-img-urls.s3.amazonaws.com/interior-3778708_960_720.jpg";
//        String url90 = "https://s3-img-urls.s3.amazonaws.com/interior-design-4467768_960_720.jpg";
//        String url91 = "https://s3-img-urls.s3.amazonaws.com/interior-design-5689717__340.jpg";
//        String url92 = "https://s3-img-urls.s3.amazonaws.com/interior-design-5689717_960_720.jpg";
//        String url93 = "https://s3-img-urls.s3.amazonaws.com/interior-design-5689746_960_720.jpg";
//        String url94 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1159680601-612x612.jpg";
//        String url95 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1162699370-612x612.jpg";
//        String url96 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1218576553-612x612.jpg";
//        String url97 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1277748938-612x612.jpg";
//        String url98 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1305880574-612x612.jpg";
//        String url99 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1306626046-612x612.jpg";
//        String url100 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1320935446-612x612.jpg";
//        String url101 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1323779285-612x612.jpg";
//        String url102 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-1334372840-612x612.jpg";
//        String url103 = "https://s3-img-urls.s3.amazonaws.com/istockphoto-859223164-612x612.jpg";
//        String url104 = "https://s3-img-urls.s3.amazonaws.com/john-work-garrett-library-211375__340.jpg";
//        String url105 = "https://s3-img-urls.s3.amazonaws.com/kitchen-1336160_960_720.jpg";
//        String url106 = "https://s3-img-urls.s3.amazonaws.com/kitchen-1867663_960_720.jpg";
//        String url107 = "https://s3-img-urls.s3.amazonaws.com/kitchen-1940174_960_720.jpg";
//        String url108 = "https://s3-img-urls.s3.amazonaws.com/kitchen-1940177_960_720.jpg";
//        String url109 = "https://s3-img-urls.s3.amazonaws.com/kitchen-2094707_960_720.jpg";
//        String url110 = "https://s3-img-urls.s3.amazonaws.com/kitchen-1543493_960_720.jpg";
//        String url111 = "https://s3-img-urls.s3.amazonaws.com/kitchen-2094723__340.jpg";
//        String url112 = "https://s3-img-urls.s3.amazonaws.com/kitchen-2094723_960_720.jpg";
//        String url113 = "https://s3-img-urls.s3.amazonaws.com/kitchen-2094738__340.jpg";
//        String url114 = "https://s3-img-urls.s3.amazonaws.com/kitchen-2165756_960_720.jpg";
//        String url115 = "https://s3-img-urls.s3.amazonaws.com/kitchen-2400367_960_720.jpg";
//        String url116 = "https://s3-img-urls.s3.amazonaws.com/kitchen-3623328__340.jpg";
//        String url117 = "https://s3-img-urls.s3.amazonaws.com/kitchen-4043098_960_720.jpg";
//        String url118 = "https://s3-img-urls.s3.amazonaws.com/kitchen-4695948__340.jpg";
//        String url119 = "https://s3-img-urls.s3.amazonaws.com/kitchen-673733_960_720.jpg";
//        String url120 = "https://s3-img-urls.s3.amazonaws.com/lifestyle-3107041_960_720.jpg";
//        String url121 = "https://s3-img-urls.s3.amazonaws.com/living-room-1835923_960_720.jpg";
//        String url122 = "https://s3-img-urls.s3.amazonaws.com/living-room-1952072_960_720.jpg";
//        String url123 = "https://s3-img-urls.s3.amazonaws.com/living-room-2569325_960_720.jpg";
//        String url124 = "https://s3-img-urls.s3.amazonaws.com/living-room-2583032_960_720.jpg";
//        String url125 = "https://s3-img-urls.s3.amazonaws.com/living-room-2732939_960_720.jpg";
//        String url126 = "https://s3-img-urls.s3.amazonaws.com/living-room-3498914__340.jpg";
//        String url127 = "https://s3-img-urls.s3.amazonaws.com/living-room-3603777_960_720.jpg";
//        String url128 = "https://s3-img-urls.s3.amazonaws.com/living-room-5502982_960_720.jpg";
//        String url129 = "https://s3-img-urls.s3.amazonaws.com/living-room-5570442_960_720.jpg";
//        String url130 = "https://s3-img-urls.s3.amazonaws.com/living-room-5570510_960_720.jpg";
//        String url131 = "https://s3-img-urls.s3.amazonaws.com/living-room-5570515_960_720.jpg";
//        String url132 = "https://s3-img-urls.s3.amazonaws.com/living-room-581073_960_720.jpg";
//        String url133 = "https://s3-img-urls.s3.amazonaws.com/living-room-modern-tv-4813589_960_720.jpg";
//        String url134 = "https://s3-img-urls.s3.amazonaws.com/living-room-modern-tv-4813591_960_720.jpg";
//        String url135 = "https://s3-img-urls.s3.amazonaws.com/lobby-346426__340.jpg";
//        String url136 = "https://s3-img-urls.s3.amazonaws.com/new-england-1336173_960_720.jpg";
//        String url137 = "https://s3-img-urls.s3.amazonaws.com/new-england-style-house-2826065_960_720.jpg";
//        String url138 = "https://s3-img-urls.s3.amazonaws.com/nursery-1078923_960_720.jpg";
//        String url139 = "https://s3-img-urls.s3.amazonaws.com/office-332211__340.jpg";
//        String url140 = "https://s3-img-urls.s3.amazonaws.com/office-730681__340.jpg";
//        String url141 = "https://s3-img-urls.s3.amazonaws.com/office-space-1744801__340.jpg";
//        String url142 = "https://s3-img-urls.s3.amazonaws.com/office-space-1744803_960_720.jpg";
//        String url143 = "https://s3-img-urls.s3.amazonaws.com/office-space-1744805__340.jpg";
//        String url144 = "https://s3-img-urls.s3.amazonaws.com/pavilion-321036__340.jpg";
//        String url145 = "https://s3-img-urls.s3.amazonaws.com/pool-1318072_960_720.jpg";
//        String url146 = "https://s3-img-urls.s3.amazonaws.com/pool-5055009_960_720.jpg";
//        String url147 = "https://s3-img-urls.s3.amazonaws.com/pool-958429_960_720.jpg";
//        String url148 = "https://s3-img-urls.s3.amazonaws.com/real-estate-4955086_960_720.jpg";
//        String url149 = "https://s3-img-urls.s3.amazonaws.com/real-estate-4955087_960_720.jpg";
//        String url150 = "https://s3-img-urls.s3.amazonaws.com/real-estate-4955093_960_720.jpg";
//        String url151 = "https://s3-img-urls.s3.amazonaws.com/residence-2238987_960_720.jpg";
//        String url152 = "https://s3-img-urls.s3.amazonaws.com/room-1334323__340.jpg";
//        String url153 = "https://s3-img-urls.s3.amazonaws.com/room-416043__340.jpg";
//        String url154 = "https://s3-img-urls.s3.amazonaws.com/shower-389273_960_720.jpg";
//        String url155 = "https://s3-img-urls.s3.amazonaws.com/sofa-1078931__340.jpg";
//        String url156 = "https://s3-img-urls.s3.amazonaws.com/sofa-184551_960_720.jpg";
//        String url157 = "https://s3-img-urls.s3.amazonaws.com/sofa-3538227__340.jpg";
//        String url158 = "https://s3-img-urls.s3.amazonaws.com/staging-2816464__340.jpg";
//        String url159 = "https://s3-img-urls.s3.amazonaws.com/sunbeds-2446568__340.jpg";
//        String url160 = "https://s3-img-urls.s3.amazonaws.com/swimming-pool-3652690_960_720.jpg";
//        String url161 = "https://s3-img-urls.s3.amazonaws.com/travel-1737168_960_720.jpg";
//        String url162 = "https://s3-img-urls.s3.amazonaws.com/travel-1737170_960_720.jpg";
//        String url163 = "https://s3-img-urls.s3.amazonaws.com/travel-1737171_960_720.jpg";
//        String url164 = "https://s3-img-urls.s3.amazonaws.com/villa-194671_960_720.jpg";
//        String url165 = "https://s3-img-urls.s3.amazonaws.com/villa-4501999_960_720.jpg";
//        String url166 = "https://s3-img-urls.s3.amazonaws.com/villa-4555818__340.jpg";
//        String url167 = "https://s3-img-urls.s3.amazonaws.com/villa-4555818_960_720.jpg";
//        String url168 = "https://s3-img-urls.s3.amazonaws.com/villa-4555824__340.jpg";
//        String url169 = "https://s3-img-urls.s3.amazonaws.com/villa-4555824_960_720.jpg";
//        String url170 = "https://s3-img-urls.s3.amazonaws.com/villa-4612582_960_720.jpg";
//        String url171 = "https://s3-img-urls.s3.amazonaws.com/villa-600176_960_720.jpg";
//        String url172 = "https://s3-img-urls.s3.amazonaws.com/villa-cortine-palace-949547__340.jpg";
//        String url173 = "https://s3-img-urls.s3.amazonaws.com/wall-416060_960_720.jpg";
//        String url174 = "https://s3-img-urls.s3.amazonaws.com/western-143213_960_720.jpg";
//        String url175 = "https://s3-img-urls.s3.amazonaws.com/living-room-5502982_960_720.jpg";
//        String url176 = "https://s3-img-urls.s3.amazonaws.com/travel-1737171_960_720.jpg";
//        String url177 = "https://s3-img-urls.s3.amazonaws.com/office-730681__340.jpg";
//        String url178 = "https://s3-img-urls.s3.amazonaws.com/lobby-346426__340.jpg";
//        String url179 = "https://s3-img-urls.s3.amazonaws.com/sofa-3538227__340.jpg";
//        String url180 = "https://cdn.pixabay.com/photo/2017/07/09/03/19/home-2486092_960_720.jpg";
//        String url181 = "https://s3-img-urls.s3.amazonaws.com/wall-416060_960_720.jpg";
//        String url182 = "https://cdn.pixabay.com/photo/2016/10/13/09/08/travel-1737171_960_720.jpg";
//        String url183 = "https://s3-img-urls.s3.amazonaws.com/office-730681__340.jpg";
//        String url184 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094700__340.jpg";
//        String url185 = "https://s3-img-urls.s3.amazonaws.com/apartment-2094702__340.jpg";
//        String url186 = "https://s3-img-urls.s3.amazonaws.com/apartment-406901_960_720.jpg";
//        String url187 = "https://s3-img-urls.s3.amazonaws.com/apartment-416039__340.jpg";
//        String url188 = "https://s3-img-urls.s3.amazonaws.com/apartment-lounge-3147892_960_720.jpg";
//        String url189 = "https://s3-img-urls.s3.amazonaws.com/apartments-1845884_960_720.jpg";
//        String url190 = "https://s3-img-urls.s3.amazonaws.com/architecture-2141045__340.jpg";
//        String url191 = "https://s3-img-urls.s3.amazonaws.com/architecture-2804083_960_720.jpg";
//        String url192 = "https://s3-img-urls.s3.amazonaws.com/architecture-5339245_960_720.jpg";
//        String url193 = "https://s3-img-urls.s3.amazonaws.com/bath-3622540__340.jpg";
//        String url194 = "https://s3-img-urls.s3.amazonaws.com/bathroom-2094733_960_720.jpg";
//        String url195 = "https://s3-img-urls.s3.amazonaws.com/bathroom-4032529__340.jpg";
//        String url196 = "https://s3-img-urls.s3.amazonaws.com/bathroom-6686057_960_720.jpg";
//        String url197 = "https://s3-img-urls.s3.amazonaws.com/house-1836070_960_720.jpg";
//        String url198 = "https://s3-img-urls.s3.amazonaws.com/bed-1834327_960_720.jpg";
//        String url199 = "https://s3-img-urls.s3.amazonaws.com/bed-1839183_960_720.jpg";
//        String url200 = "https://s3-img-urls.s3.amazonaws.com/bed-625386_960_720.jpg";
//
//
//
//        Image image1 = imageService.createImage(new Image(null, "foto 1", url1, new Date()));
//        Image image2 = imageService.createImage(new Image(null, "foto 2", url2, new Date()));
//        Image image3 = imageService.createImage(new Image(null, "foto 3", url3, new Date()));
//        Image image4 = imageService.createImage(new Image(null, "foto 4", url4, new Date()));
//        Image image5 = imageService.createImage(new Image(null, "foto 5", url5, new Date()));
//        Image image6 = imageService.createImage(new Image(null, "foto 6", url6, new Date()));
//        Image image7 = imageService.createImage(new Image(null, "foto 7", url7, new Date()));
//        Image image8 = imageService.createImage(new Image(null, "foto 8", url8, new Date()));
//        Image image9 = imageService.createImage(new Image(null, "foto 9", url9, new Date()));
//        Image image10 = imageService.createImage(new Image(null, "foto 10", url10, new Date()));
//        Image image11 = imageService.createImage(new Image(null, "foto 11", url11, new Date()));
//        Image image12 = imageService.createImage(new Image(null, "foto 12", url12, new Date()));
//        Image image13 = imageService.createImage(new Image(null, "foto 13", url13, new Date()));
//        Image image14 = imageService.createImage(new Image(null, "foto 14", url14, new Date()));
//        Image image15 = imageService.createImage(new Image(null, "foto 15", url15, new Date()));
//        Image image16 = imageService.createImage(new Image(null, "foto 16", url16, new Date()));
//        Image image17 = imageService.createImage(new Image(null, "foto 17", url17, new Date()));
//        Image image18 = imageService.createImage(new Image(null, "foto 18", url18, new Date()));
//        Image image19 = imageService.createImage(new Image(null, "foto 19", url19, new Date()));
//        Image image20 = imageService.createImage(new Image(null, "foto 20", url20, new Date()));
//        Image image21 = imageService.createImage(new Image(null, "foto 21", url21, new Date()));
//        Image image22 = imageService.createImage(new Image(null, "foto 22", url22, new Date()));
//        Image image23 = imageService.createImage(new Image(null, "foto 23", url23, new Date()));
//        Image image24 = imageService.createImage(new Image(null, "foto 24", url24, new Date()));
//        Image image25 = imageService.createImage(new Image(null, "foto 25", url25, new Date()));
//        Image image26 = imageService.createImage(new Image(null, "foto 26", url26, new Date()));
//        Image image27 = imageService.createImage(new Image(null, "foto 27", url27, new Date()));
//        Image image28 = imageService.createImage(new Image(null, "foto 28", url28, new Date()));
//        Image image29 = imageService.createImage(new Image(null, "foto 29", url29, new Date()));
//        Image image30 = imageService.createImage(new Image(null, "foto 30", url30, new Date()));
//        Image image31 = imageService.createImage(new Image(null, "foto 31", url31, new Date()));
//        Image image32 = imageService.createImage(new Image(null, "foto 32", url32, new Date()));
//        Image image33 = imageService.createImage(new Image(null, "foto 33", url33, new Date()));
//        Image image34 = imageService.createImage(new Image(null, "foto 34", url34, new Date()));
//        Image image35 = imageService.createImage(new Image(null, "foto 35", url35, new Date()));
//        Image image36 = imageService.createImage(new Image(null, "foto 36", url36, new Date()));
//        Image image37 = imageService.createImage(new Image(null, "foto 37", url37, new Date()));
//        Image image38 = imageService.createImage(new Image(null, "foto 38", url38, new Date()));
//        Image image39 = imageService.createImage(new Image(null, "foto 39", url39, new Date()));
//        Image image40 = imageService.createImage(new Image(null, "foto 40", url40, new Date()));
//        Image image41 = imageService.createImage(new Image(null, "foto 41", url41, new Date()));
//        Image image42 = imageService.createImage(new Image(null, "foto 42", url42, new Date()));
//        Image image43 = imageService.createImage(new Image(null, "foto 43", url43, new Date()));
//        Image image44 = imageService.createImage(new Image(null, "foto 44", url44, new Date()));
//        Image image45 = imageService.createImage(new Image(null, "foto 45", url45, new Date()));
//        Image image46 = imageService.createImage(new Image(null, "foto 46", url46, new Date()));
//        Image image47 = imageService.createImage(new Image(null, "foto 47", url47, new Date()));
//        Image image48 = imageService.createImage(new Image(null, "foto 48", url48, new Date()));
//        Image image49 = imageService.createImage(new Image(null, "foto 49", url49, new Date()));
//        Image image50 = imageService.createImage(new Image(null, "foto 50", url50, new Date()));
//        Image image51 = imageService.createImage(new Image(null, "foto 51", url51, new Date()));
//        Image image52 = imageService.createImage(new Image(null, "foto 52", url52, new Date()));
//        Image image53 = imageService.createImage(new Image(null, "foto 53", url53, new Date()));
//        Image image54 = imageService.createImage(new Image(null, "foto 54", url54, new Date()));
//        Image image55 = imageService.createImage(new Image(null, "foto 55", url55, new Date()));
//        Image image56 = imageService.createImage(new Image(null, "foto 56", url56, new Date()));
//        Image image57 = imageService.createImage(new Image(null, "foto 57", url57, new Date()));
//        Image image58 = imageService.createImage(new Image(null, "foto 58", url58, new Date()));
//        Image image59 = imageService.createImage(new Image(null, "foto 59", url59, new Date()));
//        Image image60 = imageService.createImage(new Image(null, "foto 60", url60, new Date()));
//        Image image61 = imageService.createImage(new Image(null, "foto 61", url61, new Date()));
//        Image image62 = imageService.createImage(new Image(null, "foto 62", url62, new Date()));
//        Image image63 = imageService.createImage(new Image(null, "foto 63", url63, new Date()));
//        Image image64 = imageService.createImage(new Image(null, "foto 64", url64, new Date()));
//        Image image65 = imageService.createImage(new Image(null, "foto 65", url65, new Date()));
//        Image image66 = imageService.createImage(new Image(null, "foto 66", url66, new Date()));
//        Image image67 = imageService.createImage(new Image(null, "foto 67", url67, new Date()));
//        Image image68 = imageService.createImage(new Image(null, "foto 68", url68, new Date()));
//        Image image69 = imageService.createImage(new Image(null, "foto 69", url69, new Date()));
//        Image image70 = imageService.createImage(new Image(null, "foto 70", url70, new Date()));
//        Image image71 = imageService.createImage(new Image(null, "foto 71", url71, new Date()));
//        Image image72 = imageService.createImage(new Image(null, "foto 72", url72, new Date()));
//        Image image73 = imageService.createImage(new Image(null, "foto 73", url73, new Date()));
//        Image image74 = imageService.createImage(new Image(null, "foto 74", url74, new Date()));
//        Image image75 = imageService.createImage(new Image(null, "foto 75", url75, new Date()));
//        Image image76 = imageService.createImage(new Image(null, "foto 76", url76, new Date()));
//        Image image77 = imageService.createImage(new Image(null, "foto 77", url77, new Date()));
//        Image image78 = imageService.createImage(new Image(null, "foto 78", url78, new Date()));
//        Image image79 = imageService.createImage(new Image(null, "foto 79", url79, new Date()));
//        Image image80 = imageService.createImage(new Image(null, "foto 80", url80, new Date()));
//        Image image81 = imageService.createImage(new Image(null, "foto 81", url81, new Date()));
//        Image image82 = imageService.createImage(new Image(null, "foto 82", url82, new Date()));
//        Image image83 = imageService.createImage(new Image(null, "foto 83", url83, new Date()));
//        Image image84 = imageService.createImage(new Image(null, "foto 84", url84, new Date()));
//        Image image85 = imageService.createImage(new Image(null, "foto 85", url85, new Date()));
//        Image image86 = imageService.createImage(new Image(null, "foto 86", url86, new Date()));
//        Image image87 = imageService.createImage(new Image(null, "foto 87", url87, new Date()));
//        Image image88 = imageService.createImage(new Image(null, "foto 88", url88, new Date()));
//        Image image89 = imageService.createImage(new Image(null, "foto 89", url89, new Date()));
//        Image image90 = imageService.createImage(new Image(null, "foto 90", url90, new Date()));
//        Image image91 = imageService.createImage(new Image(null, "foto 91", url91, new Date()));
//        Image image92 = imageService.createImage(new Image(null, "foto 92", url92, new Date()));
//        Image image93 = imageService.createImage(new Image(null, "foto 93", url93, new Date()));
//        Image image94 = imageService.createImage(new Image(null, "foto 94", url94, new Date()));
//        Image image95 = imageService.createImage(new Image(null, "foto 95", url95, new Date()));
//        Image image96 = imageService.createImage(new Image(null, "foto 96", url96, new Date()));
//        Image image97 = imageService.createImage(new Image(null, "foto 97", url97, new Date()));
//        Image image98 = imageService.createImage(new Image(null, "foto 98", url98, new Date()));
//        Image image99 = imageService.createImage(new Image(null, "foto 99", url99, new Date()));
//        Image image100 = imageService.createImage(new Image(null, "foto 100", url100, new Date()));
//        Image image101 = imageService.createImage(new Image(null, "foto 101", url101, new Date()));
//        Image image102 = imageService.createImage(new Image(null, "foto 102", url102, new Date()));
//        Image image103 = imageService.createImage(new Image(null, "foto 103", url103, new Date()));
//        Image image104 = imageService.createImage(new Image(null, "foto 104", url104, new Date()));
//        Image image105 = imageService.createImage(new Image(null, "foto 105", url105, new Date()));
//        Image image106 = imageService.createImage(new Image(null, "foto 106", url106, new Date()));
//        Image image107 = imageService.createImage(new Image(null, "foto 107", url107, new Date()));
//        Image image108 = imageService.createImage(new Image(null, "foto 108", url108, new Date()));
//        Image image109 = imageService.createImage(new Image(null, "foto 109", url109, new Date()));
//        Image image110 = imageService.createImage(new Image(null, "foto 110", url110, new Date()));
//        Image image111 = imageService.createImage(new Image(null, "foto 111", url111, new Date()));
//        Image image112 = imageService.createImage(new Image(null, "foto 112", url112, new Date()));
//        Image image113 = imageService.createImage(new Image(null, "foto 113", url113, new Date()));
//        Image image114 = imageService.createImage(new Image(null, "foto 114", url114, new Date()));
//        Image image115 = imageService.createImage(new Image(null, "foto 115", url115, new Date()));
//        Image image116 = imageService.createImage(new Image(null, "foto 116", url116, new Date()));
//        Image image117 = imageService.createImage(new Image(null, "foto 117", url117, new Date()));
//        Image image118 = imageService.createImage(new Image(null, "foto 118", url118, new Date()));
//        Image image119 = imageService.createImage(new Image(null, "foto 119", url119, new Date()));
//        Image image120 = imageService.createImage(new Image(null, "foto 120", url120, new Date()));
//        Image image121 = imageService.createImage(new Image(null, "foto 121", url121, new Date()));
//        Image image122 = imageService.createImage(new Image(null, "foto 122", url122, new Date()));
//        Image image123 = imageService.createImage(new Image(null, "foto 123", url123, new Date()));
//        Image image124 = imageService.createImage(new Image(null, "foto 124", url124, new Date()));
//        Image image125 = imageService.createImage(new Image(null, "foto 125", url125, new Date()));
//        Image image126 = imageService.createImage(new Image(null, "foto 126", url126, new Date()));
//        Image image127 = imageService.createImage(new Image(null, "foto 127", url127, new Date()));
//        Image image128 = imageService.createImage(new Image(null, "foto 128", url128, new Date()));
//        Image image129 = imageService.createImage(new Image(null, "foto 129", url129, new Date()));
//        Image image130 = imageService.createImage(new Image(null, "foto 130", url130, new Date()));
//        Image image131 = imageService.createImage(new Image(null, "foto 131", url131, new Date()));
//        Image image132 = imageService.createImage(new Image(null, "foto 132", url132, new Date()));
//        Image image133 = imageService.createImage(new Image(null, "foto 133", url133, new Date()));
//        Image image134 = imageService.createImage(new Image(null, "foto 134", url134, new Date()));
//        Image image135 = imageService.createImage(new Image(null, "foto 135", url135, new Date()));
//        Image image136 = imageService.createImage(new Image(null, "foto 136", url136, new Date()));
//        Image image137 = imageService.createImage(new Image(null, "foto 137", url137, new Date()));
//        Image image138 = imageService.createImage(new Image(null, "foto 138", url138, new Date()));
//        Image image139 = imageService.createImage(new Image(null, "foto 139", url139, new Date()));
//        Image image140 = imageService.createImage(new Image(null, "foto 140", url140, new Date()));
//        Image image141 = imageService.createImage(new Image(null, "foto 141", url141, new Date()));
//        Image image142 = imageService.createImage(new Image(null, "foto 142", url142, new Date()));
//        Image image143 = imageService.createImage(new Image(null, "foto 143", url143, new Date()));
//        Image image144 = imageService.createImage(new Image(null, "foto 144", url144, new Date()));
//        Image image145 = imageService.createImage(new Image(null, "foto 145", url145, new Date()));
//        Image image146 = imageService.createImage(new Image(null, "foto 146", url146, new Date()));
//        Image image147 = imageService.createImage(new Image(null, "foto 147", url147, new Date()));
//        Image image148 = imageService.createImage(new Image(null, "foto 148", url148, new Date()));
//        Image image149 = imageService.createImage(new Image(null, "foto 149", url149, new Date()));
//        Image image150 = imageService.createImage(new Image(null, "foto 150", url150, new Date()));
//        Image image151 = imageService.createImage(new Image(null, "foto 151", url151, new Date()));
//        Image image152 = imageService.createImage(new Image(null, "foto 152", url152, new Date()));
//        Image image153 = imageService.createImage(new Image(null, "foto 153", url153, new Date()));
//        Image image154 = imageService.createImage(new Image(null, "foto 154", url154, new Date()));
//        Image image155 = imageService.createImage(new Image(null, "foto 155", url155, new Date()));
//        Image image156 = imageService.createImage(new Image(null, "foto 156", url156, new Date()));
//        Image image157 = imageService.createImage(new Image(null, "foto 157", url157, new Date()));
//        Image image158 = imageService.createImage(new Image(null, "foto 158", url158, new Date()));
//        Image image159 = imageService.createImage(new Image(null, "foto 159", url159, new Date()));
//        Image image160 = imageService.createImage(new Image(null, "foto 160", url160, new Date()));
//        Image image161 = imageService.createImage(new Image(null, "foto 161", url161, new Date()));
//        Image image162 = imageService.createImage(new Image(null, "foto 162", url162, new Date()));
//        Image image163 = imageService.createImage(new Image(null, "foto 163", url163, new Date()));
//        Image image164 = imageService.createImage(new Image(null, "foto 164", url164, new Date()));
//        Image image165 = imageService.createImage(new Image(null, "foto 165", url165, new Date()));
//        Image image166 = imageService.createImage(new Image(null, "foto 166", url166, new Date()));
//        Image image167 = imageService.createImage(new Image(null, "foto 167", url167, new Date()));
//        Image image168 = imageService.createImage(new Image(null, "foto 168", url168, new Date()));
//        Image image169 = imageService.createImage(new Image(null, "foto 169", url169, new Date()));
//        Image image170 = imageService.createImage(new Image(null, "foto 170", url170, new Date()));
//        Image image171 = imageService.createImage(new Image(null, "foto 171", url171, new Date()));
//        Image image172 = imageService.createImage(new Image(null, "foto 172", url172, new Date()));
//        Image image173 = imageService.createImage(new Image(null, "foto 173", url173, new Date()));
//        Image image174 = imageService.createImage(new Image(null, "foto 174", url174, new Date()));
//        Image image175 = imageService.createImage(new Image(null, "foto 175", url175, new Date()));
//        Image image176 = imageService.createImage(new Image(null, "foto 176", url176, new Date()));
//        Image image177 = imageService.createImage(new Image(null, "foto 177", url177, new Date()));
//        Image image178 = imageService.createImage(new Image(null, "foto 178", url178, new Date()));
//        Image image179 = imageService.createImage(new Image(null, "foto 179", url179, new Date()));
//        Image image180 = imageService.createImage(new Image(null, "foto 180", url180, new Date()));
//        Image image181 = imageService.createImage(new Image(null, "foto 181", url181, new Date()));
//        Image image182 = imageService.createImage(new Image(null, "foto 182", url182, new Date()));
//        Image image183 = imageService.createImage(new Image(null, "foto 183", url183, new Date()));
//        Image image184 = imageService.createImage(new Image(null, "foto 184", url184, new Date()));
//        Image image185 = imageService.createImage(new Image(null, "foto 185", url185, new Date()));
//        Image image186 = imageService.createImage(new Image(null, "foto 186", url186, new Date()));
//        Image image187 = imageService.createImage(new Image(null, "foto 187", url187, new Date()));
//        Image image188 = imageService.createImage(new Image(null, "foto 188", url188, new Date()));
//        Image image189 = imageService.createImage(new Image(null, "foto 189", url189, new Date()));
//        Image image190 = imageService.createImage(new Image(null, "foto 190", url190, new Date()));
//        Image image191 = imageService.createImage(new Image(null, "foto 191", url191, new Date()));
//        Image image192 = imageService.createImage(new Image(null, "foto 192", url192, new Date()));
//        Image image193 = imageService.createImage(new Image(null, "foto 193", url193, new Date()));
//        Image image194 = imageService.createImage(new Image(null, "foto 194", url194, new Date()));
//        Image image195 = imageService.createImage(new Image(null, "foto 195", url195, new Date()));
//        Image image196 = imageService.createImage(new Image(null, "foto 196", url196, new Date()));
//        Image image197 = imageService.createImage(new Image(null, "foto 197", url197, new Date()));
//        Image image198 = imageService.createImage(new Image(null, "foto 198", url198, new Date()));
//        Image image199 = imageService.createImage(new Image(null, "foto 199", url199, new Date()));
//        Image image200 = imageService.createImage(new Image(null, "foto 200", url200, new Date()));
//
//
//
//
//
//
//        /* -------- cities loading -------- */
//
//        City city1 = cityService.createCity(new City(null, "Cartagena", "Colombia", "CREATED",
//                new Date()));
//        City city2 = cityService.createCity(new City(null, "Bogotá", "Colombia", "CREATED",
//                new Date()));
//        City city3 = cityService.createCity(new City(null, "Medellin", "Colombia", "CREATED",
//                new Date()));
//        City city4 = cityService.createCity(new City(null, "Cali", "Colombia", "CREATED", new Date()));
//        City city5 = cityService.createCity(new City(null, "Barranquilla", "Colombia", "CREATED",
//                new Date()));
//        City city6 = cityService.createCity(new City(null, "Buenos Aires", "Argentina", "CREATED",
//                new Date()));
//        City city7 = cityService.createCity(new City(null, "Córdoba", "Argentina", "CREATED",
//                new Date()));
//        City city8 = cityService.createCity(new City(null, "Rosario", "Argentina", "CREATED",
//                new Date()));
//        City city9 = cityService.createCity(new City(null, "Salta", "Argentina", "CREATED",
//                new Date()));
//        City city10 = cityService.createCity(new City(null, "Corrientes", "Argentina", "CREATED",
//                new Date()));
//        City city11 = cityService.createCity(new City(null, "San José", "Costa Rica", "CREATED",
//                new Date()));
//        City city12 = cityService.createCity(new City(null, "Colón", "Panamá", "CREATED",
//                new Date()));
//        City city13 = cityService.createCity(new City(null, "Santo Domingo", "República Dominicana", "CREATED",
//                new Date()));
//        City city14 = cityService.createCity(new City(null, "Sao Paulo", "Brasil", "CREATED",
//                new Date()));
//        City city15 = cityService.createCity(new City(null, "Santiago de Chile", "Chile", "CREATED",
//                new Date()));
//
//
//        /* -------- features loading -------- */
//
//        String featureName1 = "Aire acondicionado";
//        String featureIcon1 = "FaSnowflake";
//
//        String featureName2 = "Agua caliente";
//        String featureIcon2 = "FaFire";
//
//        String featureName3 = "Jacuzzi";
//        String featureIcon3 = "FaHotTub";
//
//        String featureName4 = "Area para trabajar";
//        String featureIcon4 = "FaLaptopHouse";
//
//        String featureName5 = "Electrodomesticos cocina";
//        String featureIcon5 = "FaBlender";
//
//        String featureName6 = "Articulos basicos cocina";
//        String featureIcon6 = "FaUtensils";
//
//        String featureName7 = "Botiquín";
//        String featureIcon7 = "FaBriefcaseMedical";
//
//        String featureName8 = "Cafetera";
//        String featureIcon8 = "FaMugHot";
//
//        String featureName9 = "Calefaccion";
//        String featureIcon9 = "FaTemperatureHigh";
//
//        String featureName10 = "Wifi";
//        String featureIcon10 = "FaWifi";
//
//        String featureName11 = "Mascotas permitidas";
//        String featureIcon11 = "FaPaw";
//
//        String featureName12 = "Piscina";
//        String featureIcon12 = "FaSwimmingPool";
//
//        String featureName13 = "TV";
//        String featureIcon13 = "FaTv";
//
//        String featureName14 = "Elementos basicos";
//        String featureIcon14 = "FaToiletPaper";
//
//        String featureName15 = "Camara de seguridad";
//        String featureIcon15 = "FaVideo";
//
//        String featureName16 = "Cerradura inteligente";
//        String featureIcon16 = "FaFingerprint";
//
//        String featureName17 = "Equipo ejercicio";
//        String featureIcon17 = "FaDumbbell";
//
//        String featureName18 = "Estacionamiento Pago afuera";
//        String featureIcon18 = "FaParking";
//
//        String featureName19 = "Estacionamiento gratuito dentro";
//        String featureIcon19 = "FaCar";
//
//        String featureName20 = "Extintor";
//        String featureIcon20 = "FaFireExtinguisher";
//
//        String featureName21 = "Contenedor reciclable";
//        String featureIcon21 = "FaRecycle";
//
//        Feature feature1 = featureService.createFeature(new Feature(null, featureName1,
//                featureIcon1, new Date()));
//        Feature feature2 = featureService.createFeature(new Feature(null, featureName2,
//                featureIcon2, new Date()));
//        Feature feature3 = featureService.createFeature(new Feature(null, featureName3,
//                featureIcon3, new Date()));
//        Feature feature4 = featureService.createFeature(new Feature(null, featureName4,
//                featureIcon4, new Date()));
//        Feature feature5 = featureService.createFeature(new Feature(null, featureName5,
//                featureIcon5, new Date()));
//        Feature feature6 = featureService.createFeature(new Feature(null, featureName6,
//                featureIcon6, new Date()));
//        Feature feature7 = featureService.createFeature(new Feature(null, featureName7,
//                featureIcon7, new Date()));
//        Feature feature8 = featureService.createFeature(new Feature(null, featureName8,
//                featureIcon8, new Date()));
//        Feature feature9 = featureService.createFeature(new Feature(null, featureName9,
//                featureIcon9, new Date()));
//        Feature feature10 = featureService.createFeature(new Feature(null, featureName10,
//                featureIcon10, new Date()));
//        Feature feature11 = featureService.createFeature(new Feature(null, featureName11,
//                featureIcon11, new Date()));
//        Feature feature12 = featureService.createFeature(new Feature(null, featureName12,
//                featureIcon12, new Date()));
//        Feature feature13 = featureService.createFeature(new Feature(null, featureName13,
//                featureIcon13, new Date()));
//        Feature feature14 = featureService.createFeature(new Feature(null, featureName14,
//                featureIcon14, new Date()));
//        Feature feature15 = featureService.createFeature(new Feature(null, featureName15,
//                featureIcon15, new Date()));
//        Feature feature16 = featureService.createFeature(new Feature(null, featureName16,
//                featureIcon16, new Date()));
//        Feature feature17 = featureService.createFeature(new Feature(null, featureName17,
//                featureIcon17, new Date()));
//        Feature feature18 = featureService.createFeature(new Feature(null, featureName18,
//                featureIcon18, new Date()));
//        Feature feature19 = featureService.createFeature(new Feature(null, featureName19,
//                featureIcon19, new Date()));
//        Feature feature20 = featureService.createFeature(new Feature(null, featureName20,
//                featureIcon20, new Date()));
//        Feature feature21 = featureService.createFeature(new Feature(null, featureName21,
//                featureIcon21, new Date()));
//
//        /* -------- product loading -------- */
//
//        Product product1 = Product.builder()
//                .id(null)
//                .name("Casa en Medellín")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image1, image2, image3, image4, image5, image6, image7))
//                .category(category1)
//                .city(city1)
//                .latitude(10.42036)
//                .longitude(-75.52488)
//                .score(0.0).build();
//        productService.createProduct(product1);
//
//        Product product2 = Product.builder()
//                .id(null)
//                .name("Casa en Bogotá")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20, feature12))
//                .images(Set.of(image8, image9, image10, image11, image12, image13, image14))
//                .category(category1)
//                .city(city2)
//                .latitude(4.68421)
//                .longitude(-74.06259)
//                .score(0.0).build();
//        productService.createProduct(product2);
//
//        Product product3 = Product.builder()
//                .id(null)
//                .name("Casa en Medellín")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image15, image16, image17, image18, image19, image20, image21))
//                .category(category1)
//                .city(city3)
//                .latitude(6.25156)
//                .longitude(-75.58561)
//                .score(0.0).build();
//        productService.createProduct(product3);
//
//        Product product4 = Product.builder()
//                .id(null)
//                .name("Casa en Cali")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image22, image23, image24, image25, image26, image27, image28))
//                .category(category1)
//                .city(city4)
//                .latitude(3.46461)
//                .longitude(-76.53603)
//                .score(0.0).build();
//        productService.createProduct(product4);
//
//        Product product5 = Product.builder()
//                .id(null)
//                .name("Casa en Barranquilla")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image29, image30, image31, image32, image33, image34, image35))
//                .category(category1)
//                .city(city5)
//                .latitude(11.01161)
//                .longitude(-74.80110)
//                .score(0.0).build();
//        productService.createProduct(product5);
//
//        Product product6 = Product.builder()
//                .id(null)
//                .name("Casa en Buenos Aires")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image36, image37, image38, image39, image40, image41, image42))
//                .category(category1)
//                .city(city6)
//                .latitude(-34.66378)
//                .longitude(-58.31751)
//                .score(0.0).build();
//        productService.createProduct(product6);
//
//        Product product7 = Product.builder()
//                .id(null)
//                .name("Casa en Córdoba")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image43, image44, image45, image46, image47, image48, image49))
//                .category(category1)
//                .city(city7)
//                .latitude(-31.41739)
//                .longitude(-64.18376)
//                .score(0.0).build();
//        productService.createProduct(product7);
//
//        Product product8 = Product.builder()
//                .id(null)
//                .name("Casa en Rosario")
//                .description("HLorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20, feature12))
//                .images(Set.of(image50, image51, image52, image53, image54, image55, image56))
//                .category(category1)
//                .city(city8)
//                .latitude(-32.95878)
//                .longitude(-60.62287)
//                .score(0.0).build();
//        productService.createProduct(product8);
//
//        Product product9 = Product.builder()
//                .id(null)
//                .name("Casa en Salta")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image57, image58, image59, image60, image61, image62, image63))
//                .category(category1)
//                .city(city9)
//                .latitude(-24.75130)
//                .longitude(-65.39352)
//                .score(0.0).build();
//        productService.createProduct(product9);
//
//        Product product10 = Product.builder()
//                .id(null)
//                .name("Casa en Corrientes")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image64, image65, image66, image67, image68, image69, image70))
//                .category(category1)
//                .city(city10)
//                .latitude(-27.47187)
//                .longitude(-58.85423)
//                .score(0.0).build();
//        productService.createProduct(product10);
//
//        Product product11 = Product.builder()
//                .id(null)
//                .name("Apartamento en Buenos Aires")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature10, feature20))
//                .images(Set.of(image71, image72, image73, image74, image75))
//                .category(category2)
//                .city(city6)
//                .latitude(-34.66378)
//                .longitude(-58.31751)
//                .score(0.0).build();
//        productService.createProduct(product11);
//
//        Product product12 = Product.builder()
//                .id(null)
//                .name("Apartamento en Córdoba")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image76, image77, image78, image79, image80))
//                .category(category2)
//                .city(city7)
//                .latitude(-31.41739)
//                .longitude(-64.18376)
//                .score(0.0).build();
//        productService.createProduct(product12);
//
//        Product product13 = Product.builder()
//                .id(null)
//                .name("Apartamento en Rosario")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image81, image82, image83, image84, image85))
//                .category(category2)
//                .city(city8)
//                .latitude(-32.95878)
//                .longitude(-60.62287)
//                .score(0.0).build();
//        productService.createProduct(product13);
//
//        Product product14 = Product.builder()
//                .id(null)
//                .name("Apartamento en Salta")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image86, image87, image88, image89, image90))
//                .category(category2)
//                .city(city9)
//                .latitude(-24.75130)
//                .longitude(-65.39352)
//                .score(0.0).build();
//        productService.createProduct(product14);
//
//        Product product15 = Product.builder()
//                .id(null)
//                .name("Apartamento en Corrientes")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image91, image92, image93, image94, image95))
//                .category(category2)
//                .city(city10)
//                .latitude(-27.47187)
//                .longitude(-58.85423)
//                .score(0.0).build();
//        productService.createProduct(product15);
//
//        Product product16 = Product.builder()
//                .id(null)
//                .name("Apartamento en San José")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image96, image97, image98, image99, image100))
//                .category(category2)
//                .city(city11)
//                .latitude(9.93425)
//                .longitude(-84.10008)
//                .score(0.0).build();
//        productService.createProduct(product16);
//
//        Product product17 = Product.builder()
//                .id(null)
//                .name("Apartamento en Colón")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image101, image102, image103, image104, image105))
//                .category(category2)
//                .city(city12)
//                .latitude(9.36417)
//                .longitude(-79.89713)
//                .score(0.0).build();
//        productService.createProduct(product17);
//
//        Product product18 = Product.builder()
//                .id(null)
//                .name("Apartamento en Santo Domingo")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image106, image107, image108, image109, image110))
//                .category(category2)
//                .city(city13)
//                .latitude(18.44928)
//                .longitude(-69.92289)
//                .score(0.0).build();
//        productService.createProduct(product18);
//
//        Product product19 = Product.builder()
//                .id(null)
//                .name("Apartamento en Sao Paulo")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image111, image112, image113, image114, image115))
//                .category(category2)
//                .city(city14)
//                .latitude(-23.56681)
//                .longitude(-46.63994)
//                .score(0.0).build();
//        productService.createProduct(product19);
//
//        Product product20 = Product.builder()
//                .id(null)
//                .name("Apartamento en Santiago de Chile")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image116, image117, image118, image119, image120))
//                .category(category2)
//                .city(city15)
//                .latitude(-33.44324)
//                .longitude(-70.68613)
//                .score(0.0).build();
//        productService.createProduct(product20);
//
//        Product product21 = Product.builder()
//                .id(null)
//                .name("Finca en Cartagena")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image121, image122, image123, image124, image125))
//                .category(category3)
//                .city(city1)
//                .latitude(10.42036)
//                .longitude(-75.52488)
//                .score(0.0).build();
//        productService.createProduct(product21);
//
//        Product product22 = Product.builder()
//                .id(null)
//                .name("Finca en Bogotá")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image126, image127, image128, image129, image130))
//                .category(category3)
//                .city(city2)
//                .latitude(4.68421)
//                .longitude(-74.06259)
//                .score(0.0).build();
//        productService.createProduct(product22);
//
//        Product product23 = Product.builder()
//                .id(null)
//                .name("Finca en Medellín")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image131, image132, image133, image134, image135))
//                .category(category3)
//                .city(city3)
//                .latitude(6.25156)
//                .longitude(-75.58561)
//                .score(0.0).build();
//        productService.createProduct(product23);
//
//        Product product24 = Product.builder()
//                .id(null)
//                .name("Finca en Cali")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image136, image137, image138, image139, image140))
//                .category(category3)
//                .city(city4)
//                .latitude(3.46461)
//                .longitude(-76.53603)
//                .score(0.0).build();
//        productService.createProduct(product24);
//
//        Product product25 = Product.builder()
//                .id(null)
//                .name("Finca en Barranquilla")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image141, image142, image143, image144, image145))
//                .category(category3)
//                .city(city5)
//                .latitude(11.01161)
//                .longitude(-74.80110)
//                .score(0.0).build();
//        productService.createProduct(product25);
//
//        Product product26 = Product.builder()
//                .id(null)
//                .name("Finca en Buenos Aires")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image146, image147, image148, image149, image150))
//                .category(category3)
//                .city(city6)
//                .latitude(-34.66378)
//                .longitude(-58.31751)
//                .score(0.0).build();
//        productService.createProduct(product26);
//
//        Product product27 = Product.builder()
//                .id(null)
//                .name("Finca en Córdoba")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image151, image152, image153, image154, image155))
//                .category(category3)
//                .city(city7)
//                .latitude(-31.41739)
//                .longitude(-64.18376)
//                .score(0.0).build();
//        productService.createProduct(product27);
//
//        Product product28 = Product.builder()
//                .id(null)
//                .name("Finca en Rosario")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image156, image157, image158, image159, image160))
//                .category(category3)
//                .city(city8)
//                .latitude(-32.95878)
//                .longitude(-60.62287)
//                .score(0.0).build();
//        productService.createProduct(product28);
//
//        Product product29 = Product.builder()
//                .id(null)
//                .name("Finca en Salta")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image161, image162, image163, image164, image165))
//                .category(category3)
//                .city(city9)
//                .latitude(-24.75130)
//                .longitude(-65.39352)
//                .score(0.0).build();
//        productService.createProduct(product29);
//
//        Product product30 = Product.builder()
//                .id(null)
//                .name("Finca en Corrientes")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image166, image167, image168, image169, image170))
//                .category(category3)
//                .city(city10)
//                .latitude(-27.47187)
//                .longitude(-58.85423)
//                .score(0.0).build();
//        productService.createProduct(product30);
//
//        Product product31 = Product.builder()
//                .id(null)
//                .name("Mansión en San José")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image171, image172, image173, image174, image175))
//                .category(category4)
//                .city(city11)
//                .latitude(9.93425)
//                .longitude(-84.10008)
//                .score(0.0).build();
//        productService.createProduct(product31);
//
//        Product product32 = Product.builder()
//                .id(null)
//                .name("Mansión en Colón")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image176, image177, image178, image179, image180))
//                .category(category4)
//                .city(city12)
//                .latitude(9.36417)
//                .longitude(-79.89713)
//                .score(0.0).build();
//        productService.createProduct(product32);
//
//        Product product33 = Product.builder()
//                .id(null)
//                .name("Mansión en Santo Domingo")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image181, image182, image183, image184, image185))
//                .category(category4)
//                .city(city13)
//                .latitude(18.44928)
//                .longitude(-69.92289)
//                .score(0.0).build();
//        productService.createProduct(product33);
//
//        Product product34 = Product.builder()
//                .id(null)
//                .name("Mansión en Sao Paulo")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image186, image187, image188, image189, image190))
//                .category(category4)
//                .city(city14)
//                .latitude(-23.56681)
//                .longitude(-46.63994)
//                .score(0.0).build();
//        productService.createProduct(product34);
//
//        Product product35 = Product.builder()
//                .id(null)
//                .name("Mansión en Santiago de Chile")
//                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dignissim turpis et ex ullamcorper sodales")
//                .features(Set.of(feature1, feature2, feature14, feature15, feature10, feature20))
//                .images(Set.of(image191, image192, image193, image194, image195))
//                .category(category4)
//                .city(city15)
//                .latitude(-33.44324)
//                .longitude(-70.68613)
//                .score(0.0).build();
//        productService.createProduct(product35);
//
//
//
//
//        /* -------- score loading -------- */
//
//        scoreService.createScore(new Score(null, 1L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 1L, 1L, 3.0, new Date()));
//        scoreService.createScore(new Score(null, 1L, 1L, 2.0, new Date()));
//        scoreService.createScore(new Score(null, 2L, 2L, 2.0, new Date()));
//        scoreService.createScore(new Score(null, 2L, 2L, 2.0, new Date()));
//        scoreService.createScore(new Score(null, 2L, 2L, 2.0, new Date()));
//        scoreService.createScore(new Score(null, 3L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 4L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 5L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 6L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 7L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 8L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 9L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 10L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 11L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 12L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 13L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 14L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 15L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 16L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 17L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 18L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 19L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 20L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 21L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 22L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 23L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 24L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 25L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 26L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 27L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 28L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 29L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 30L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 31L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 32L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 33L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 34L, 1L, 5.0, new Date()));
//        scoreService.createScore(new Score(null, 35L, 1L, 5.0, new Date()));
//
    }
}



