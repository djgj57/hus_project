package io.hus.service.scoreService;


import io.hus.entity.scoreEntity.Score;

import io.hus.repository.scoreRepo.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    final static Logger log = Logger.getLogger(ScoreServiceImpl.class);

    private final ScoreRepository scoreRepository;

    @Override
    public Score createScore(Score score) {
        log.info("Saving in db new score of " + score.getScore() + " given by the user " + score.getUsuario_id() + " for the product " + score.getProduct_id());
        return scoreRepository.save(score);
    }

    @Override
    public double getScore(Long idProducto) {
        try {
            return scoreRepository.getScore(idProducto);
        } catch (Exception e) {
            return 0.0;
        }
    }

}