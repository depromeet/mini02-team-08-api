package com.depromeet.donkey.area;

import com.depromeet.donkey.domain.donkey.Area;
import com.depromeet.donkey.domain.donkey.repository.AreaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
  @Autowired AreaRepository areaRepository;

  public List<Area> findAll() {
    return areaRepository.findAll();
  }

  public Area findOne(Integer no) {
    return areaRepository.findOne(no);
  }

  /**
   * si, gu, dong 으로 찾아서, 존재하면 해당 Area 정보를 리턴하고,
   * 없다면 생성해서 return 한다.
   *
   * @param si   시
   * @param gu   구
   * @param dong 동
   * @return
   */
  public Area findOneAndIfNotExistCreate(String si, String gu, String dong) {
    return areaRepository.findAreaBySiAndGuAndDong(si, gu, dong)
        .orElse(areaRepository.save(Area.from(si, gu, dong)));
  }

  public void insert(AreaRequest areaRequest) {
    areaRepository.save(Area.from(areaRequest));
  }
}
