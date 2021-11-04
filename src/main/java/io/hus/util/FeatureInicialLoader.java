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
        String featureIcon1 = "";

        String featureName2 = "feature2";
        String featureIcon2 = "";

        String featureName3 = "feature3";
        String featureIcon3 = "";

        String featureName4 = "feature4";
        String featureIcon4 = "";

        String featureName5 = "feature5";
        String featureIcon5 = "";

        String featureName6 = "feature6";
        String featureIcon6 = "";

        String featureName7 = "feature7";
        String featureIcon7 = "";

        String featureName8 = "feature8";
        String featureIcon8 = "";

        String featureName9 = "feature9";
        String featureIcon9 = "";

        String featureName10 = "feature10";
        String featureIcon10 = "";

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

    }
}



