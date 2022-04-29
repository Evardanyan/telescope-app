package com.epam.telescope.controller;

import com.epam.telescope.dto.SkillDto;
import com.epam.telescope.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/skill")
public class SkillController {

     private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillDto>> getSkills() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> getSkill(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getSkillById(id));
    }

    @PostMapping
    public ResponseEntity<SkillDto> addSkill(@Valid @RequestBody SkillDto skillDto) {
        skillService.addSkill(skillDto);
        return ResponseEntity.status(HttpStatus.OK).body(skillDto);
    }

    @PutMapping
    public ResponseEntity<SkillDto> updateSkill(@Valid @RequestBody SkillDto skillDto) {
        skillService.updateSkill(skillDto);
        return ResponseEntity.status(HttpStatus.OK).body(skillDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@NotNull @Positive @PathVariable Long id) {
        skillService.deleteSkillById(id);
        return ResponseEntity.noContent().build();
    }
}
