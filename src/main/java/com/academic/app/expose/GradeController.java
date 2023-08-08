package com.academic.app.expose;

import com.academic.app.business.GradeService;
import com.academic.app.expose.dto.GradeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<GradeDto.Response>> listGrade(){
        return new ResponseEntity<>(gradeService.listGrade(), HttpStatus.OK);
    }
    @GetMapping("/{idGrade}")
    public ResponseEntity<GradeDto.Response> findGradeById(@PathVariable("idGrade") Long idGrade){
        return new ResponseEntity<>(gradeService.findGradeById(idGrade), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<GradeDto.Response> saveGrade(@RequestBody GradeDto.Request request){
        return new ResponseEntity<>(gradeService.saveGrade(request), HttpStatus.OK);
    }
    @PutMapping("/{idGrade}")
    public ResponseEntity<GradeDto.Response> updateGrade(@PathVariable("idGrade") Long idGrade, @RequestBody  GradeDto.Request request){
        return new ResponseEntity<>(gradeService.updateGrade(idGrade, request), HttpStatus.OK);
    }
    @DeleteMapping("/{idGrade}")
    public ResponseEntity<Void> deleteGrade(@PathVariable("idGrade") Long idGrade){
        gradeService.deleteGrade(idGrade);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
