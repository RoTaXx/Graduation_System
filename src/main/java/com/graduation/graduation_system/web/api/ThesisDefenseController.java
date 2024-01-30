package com.graduation.graduation_system.web.api;


import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseDTO;
import com.graduation.graduation_system.service.ThesisDefenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thesis-defenses")
@AllArgsConstructor
public class ThesisDefenseController {

    private final ThesisDefenseService thesisDefenseService;

    @GetMapping
    public List<ThesisDefenseDTO> getAllThesisDefenses() {
        return thesisDefenseService.getAllThesisDefenses();
    }


   /* @PutMapping("/{id}")
    public ThesisDefenseDTO updateThesisDefense(@PathVariable Long id, @RequestBody ThesisDefenseDTO thesisDefenseDTO) {
        return thesisDefenseService.updateThesisDefense(id, thesisDefenseDTO);
    }*/

}
