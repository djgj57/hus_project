package io.hus.service.imageService;

import io.hus.entity.imageEntity.Image;

public interface ImageService {

    public Image createImage(Image image);

    public Image updateImage(Image image);

    public void deleteImage(Long id);

    public Image getImage(Long id);
}
