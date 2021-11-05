package io.hus.service.imageService;

import io.hus.entity.imageEntity.Image;
import io.hus.repository.imageRepo.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    final static Logger log = Logger.getLogger(ImageServiceImpl.class);

    private final ImageRepository imageRepository;

    @Override
    public Image createImage(Image image) {
        log.info("Saving new image: " + image.getTitle() + " to the database");
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Image image) {
        log.info("Update image: " + image.getTitle());
        Image imageToUpdate = getImage(image.getId());
        if(null == imageToUpdate) {
            return null;
        }
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        log.info("Delete image with id " + id);
        imageRepository.deleteById(id);
    }

    @Override
    public Image getImage(Long id) {
        log.info("Getting image with id " + id);
        return imageRepository.findById(id).orElse(null);
    }


}
