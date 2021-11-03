package io.hus.service.featureService;

import io.hus.entity.featureEntity.Feature;
import io.hus.repository.featureRepo.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    final static Logger log = Logger.getLogger(FeatureServiceImpl.class);

    private final FeatureRepository featureRepository;

    @Override
    public Feature createFeature(Feature feature) {
        log.info("Saving new feature: " + feature.getName() + " to the database");
        return featureRepository.save(feature);
    }

    @Override
    public Feature updateFeature(Feature feature) {
        log.info("Update feature: " + feature.getName());
        Feature featureToUpdate = getFeature(feature.getId());
        if(null == featureToUpdate) {
            return null;
        }
        return featureRepository.save(feature);
    }

    @Override
    public void deleteFeature(Long id) {
        log.info("Delete feature with id " + id);
        featureRepository.deleteById(id);
    }

    @Override
    public Feature getFeature(Long id) {
        return featureRepository.findById(id).orElse(null);
    }

}
