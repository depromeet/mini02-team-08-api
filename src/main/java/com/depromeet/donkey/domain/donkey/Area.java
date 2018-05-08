package com.depromeet.donkey.domain.donkey;


import com.depromeet.donkey.area.AreaRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(
    name = "area",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"si", "gu", "dong"})}
)
public class Area {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "no") Integer no;

  @Column(name = "si") String si;
  @Column(name = "gu") String gu;
  @Column(name = "dong") String dong;

  public static Area from(String si, String gu, String dong) {
    Area area = new Area();
    area.setSi(si);
    area.setGu(gu);
    area.setDong(dong);
    return area;
  }

  public static Area from(AreaRequest areaRequest) {
    return from(areaRequest.getSi(), areaRequest.getGu(), areaRequest.getDong());
  }
}
