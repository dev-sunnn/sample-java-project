package com.example.app.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * サンプル情報 リクエストデータ
 */
@Data
public class SampleRequest implements Serializable {

    /**
     * 名前
     */
    @NotEmpty(message = "名前を入力してください")
    @Size(max = 100, message = "名前は100文字以内で入力してください")
    private String name;

    /**
     * パス
     */
    @NotEmpty(message = "パスを入力してください")
    @Size(max = 2000, message = "パスは2000文字以内で入力してください")
    private String path;
}