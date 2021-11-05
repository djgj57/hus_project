package io.hus.service.scoreService;

import io.hus.entity.scoreEntity.Score;

public interface ScoreService {

    public Score createScore(Score score);

    public double getScore(Long idProducto);
}
