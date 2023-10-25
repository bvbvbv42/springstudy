package com.gdu.bbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.bbs.dto.BbsDto;

@Mapper
public interface BbsMapper {
  public List<BbsDto> getBbsList(Map<String, Object> map); // 인터페이스는 본문이 없음
  // xml로 이동한다
  // xml을 호출한다
  // 인터페이스 호출하면 BbsMapper 실행
  // bbsmapper.xml이랑 한몸
  
  public int getBbsCount();
}
