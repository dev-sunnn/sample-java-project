package com.example.app.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * サンプル情報 Entity
 */
@Entity
@Data
@Table(name = "sample")
public class Sample implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 名前
   */
  @Column(name = "name")
  private String name;

  /**
   * パス
   */
  @Column(name = "path")
  private String path;

  /**
   * 更新日時
   */
  @Column(name = "update_date")
  private Date updateDate;

  /**
   * 登録日時
   */
  @Column(name = "create_date")
  private Date createDate;

  /**
   * 削除日時
   */
  @Column(name = "delete_date")
  private Date deleteDate;
}
