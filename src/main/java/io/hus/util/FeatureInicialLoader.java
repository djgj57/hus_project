package io.hus.util;


import io.hus.entity.featureEntity.Feature;
import io.hus.entity.imageEntity.Image;
import io.hus.service.featureService.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class FeatureInicialLoader implements ApplicationRunner {

    private final FeatureService featureService;

    @Override
    public void run(ApplicationArguments args) {

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



        featureService.createFeature(new Feature(null, featureName1, featureIcon1, new Date()));
        featureService.createFeature(new Feature(null, featureName2, featureIcon2, new Date()));
        featureService.createFeature(new Feature(null, featureName3, featureIcon3, new Date()));
        featureService.createFeature(new Feature(null, featureName4, featureIcon4, new Date()));
        featureService.createFeature(new Feature(null, featureName5, featureIcon5, new Date()));
        featureService.createFeature(new Feature(null, featureName6, featureIcon6, new Date()));
        featureService.createFeature(new Feature(null, featureName7, featureIcon7, new Date()));
        featureService.createFeature(new Feature(null, featureName8, featureIcon8, new Date()));
        featureService.createFeature(new Feature(null, featureName9, featureIcon9, new Date()));
        featureService.createFeature(new Feature(null, featureName10, featureIcon10, new Date()));
        featureService.createFeature(new Feature(null, featureName11, featureIcon11, new Date()));
        featureService.createFeature(new Feature(null, featureName12, featureIcon12, new Date()));
        featureService.createFeature(new Feature(null, featureName13, featureIcon13, new Date()));
        featureService.createFeature(new Feature(null, featureName14, featureIcon14, new Date()));
        featureService.createFeature(new Feature(null, featureName15, featureIcon15, new Date()));
        featureService.createFeature(new Feature(null, featureName16, featureIcon16, new Date()));
        featureService.createFeature(new Feature(null, featureName17, featureIcon17, new Date()));
        featureService.createFeature(new Feature(null, featureName18, featureIcon18, new Date()));
        featureService.createFeature(new Feature(null, featureName19, featureIcon19, new Date()));
        featureService.createFeature(new Feature(null, featureName20, featureIcon20, new Date()));
        featureService.createFeature(new Feature(null, featureName21, featureIcon21, new Date()));



    }
}



