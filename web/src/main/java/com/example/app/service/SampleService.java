package com.example.app.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dto.SampleRequest;
import com.example.app.dto.SampleUpdateRequest;
import com.example.app.entity.Sample;
import com.example.app.repository.SampleRepository;

/**
 * サンプル情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SampleService {
  /**
   * サンプル情報 Repository
   */
  @Autowired
  private SampleRepository sampleRepository;

  /**
   * サンプル情報 ID検索
   * 
   * @return 検索結果
   */
  public Sample searchById(long id) {
    return sampleRepository.findById(id).get();
  }

  /**
   * サンプル情報 全検索
   * 
   * @return 検索結果
   */
  public List<Sample> searchAll() {
    return sampleRepository.findAll();
  }

  /**
   * サンプル情報 登録
   * 
   * @param sampleRequest 登録用リクエストデータ
   */
  public void create(SampleRequest sampleRequest) {
    Date now = new Date();
    Sample sample = new Sample();
    sample.setName(sampleRequest.getName());
    sample.setPath(sampleRequest.getPath());
    sample.setCreateDate(now);
    sample.setUpdateDate(now);
    sampleRepository.save(sample);
  }

  /**
   * サンプル情報 更新
   * 
   * @param sampleUpdateRequest 更新用リクエストデータ
   */
  public void update(SampleUpdateRequest sampleUpdateRequest) {
    Sample sample = searchById(sampleUpdateRequest.getId());
    sample.setName(sampleUpdateRequest.getName());
    sample.setPath(sampleUpdateRequest.getPath());
    sample.setUpdateDate(new Date());
    sampleRepository.save(sample);
  }

  /**
   * サンプル情報 物理削除
   * 
   * @param id サンプルID
   */
  public void delete(Long id) {
    Sample sample = searchById(id);
    sampleRepository.delete(sample);
  }
}
