package com.depromeet.donkey.area;

import com.depromeet.donkey.domain.donkey.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 현재로써는 필요 없어보임.
@RestController
@RequestMapping("/api/v1/area")
public class AreaController {

  @Autowired AreaService areaService;

  @GetMapping
  public List<Area> fetchAll() {
    return areaService.findAll();
  }

  @GetMapping("/{si}/{gu}/{dong}")
  public Area fetchOne(
      @PathVariable String si, @PathVariable String gu, @PathVariable String dong) {
    return areaService.findOneAndIfNotExistCreate(si, gu, dong);
  }

  @PostMapping
  public void insert(@RequestBody AreaRequest areaRequest) {
    areaService.insert(areaRequest);
  }
}
