package io.hus.controller.scoreController;

import io.hus.entity.imageEntity.Image;
import io.hus.entity.scoreEntity.Score;
import io.hus.entity.userEntity.User;
import io.hus.service.scoreService.ScoreService;
import io.hus.service.userService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Base64;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@SecurityRequirement(name = "javainuseapi")
public class ScoreController {

    private final ScoreService scoreService;
    private final UserService userService;

    @Operation(summary = "Create a new score")
    @PostMapping(value = "/score/{idproduct}/{score}")
    public ResponseEntity<Score> createScore(@RequestHeader String Authorization, @PathVariable(
            "idproduct") Long idproduct, @PathVariable(
            "score") Long score) throws JSONException {
        if(score<0 || score>5){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        String response = Authorization;
        response = response.substring(7).split("\\.")[1];
        response = new String(Base64.getDecoder().decode(response));
        JSONObject obj = new JSONObject(response);
        User user = userService.getUser(obj.getString("sub"));
        Long idUser = user.getId();
        Score scoreCreate = scoreService.createScore(new Score(null, idproduct, idUser, score,
                new Date()));
        return ResponseEntity.status(HttpStatus.CREATED).body(scoreCreate);
    }

    //GEt score by id
    @Operation(summary = "Obtain the score of a product")
    @GetMapping(value = "/open/score/{idproducto}")
    public ResponseEntity<Double> getScore(@PathVariable("idproducto") Long idproducto) {
        double score = scoreService.getScore(idproducto);
        return ResponseEntity.ok(score);
    }

}
