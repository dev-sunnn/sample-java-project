package com.example.app.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * サンプル情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SampleUpdateRequest extends SampleRequest {
    /**
     * サンプルID
     */
    @NotNull
    private Long id;
}
