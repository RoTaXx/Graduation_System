package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseInfoDTO;
import com.graduation.graduation_system.service.ThesisDefenseInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thesis-defense-infos")
@AllArgsConstructor
public class ThesisDefenseInfoController {

    private final ThesisDefenseInfoService thesisDefenseInfoService;

    @GetMapping
    public List<ThesisDefenseInfoDTO> getAllThesisDefenseInfos() {
        return thesisDefenseInfoService.getAllThesisDefenseInfos();
    }


  /*  @PutMapping("/{id}")
    public ThesisDefenseInfoDTO updateThesisDefenseInfo(@PathVariable Long id, @RequestBody ThesisDefenseInfoDTO thesisDefenseInfoDTO) {
        return thesisDefenseInfoService.updateThesisDefenseInfo(id, thesisDefenseInfoDTO);
    }*/

}
