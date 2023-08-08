package com.academic.app.expose;

import com.academic.app.business.LevelService;
import com.academic.app.expose.dto.LevelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/level")
public class LevelController {

    private final LevelService levelService;

    @GetMapping
    public ResponseEntity<List<LevelDto.Response>> listLevel(){
        return new ResponseEntity<>(levelService.listLevel(), HttpStatus.OK);
    }
    @GetMapping("/{idLevel}")
    public ResponseEntity<LevelDto.Response> findLevelById(@PathVariable("idLevel") Long idLevel){
        return new ResponseEntity<>(levelService.findLevelById(idLevel), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LevelDto.Response> saveLevel(@RequestBody LevelDto.Request request){
        return new ResponseEntity<>(levelService.saveLevel(request), HttpStatus.OK);
    }
    @PutMapping("/{idLevel}")
    public ResponseEntity<LevelDto.Response> updateLevel(@PathVariable("idLevel") Long idLevel, @RequestBody  LevelDto.Request request){
        return new ResponseEntity<>(levelService.updateLevel(idLevel, request), HttpStatus.OK);
    }
    @DeleteMapping("/{idLevel}")
    public ResponseEntity<Void> deleteLevel(@PathVariable("idLevel") Long idLevel){
        levelService.deleteLevel(idLevel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
