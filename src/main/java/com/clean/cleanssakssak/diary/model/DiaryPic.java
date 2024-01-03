package com.clean.cleanssakssak.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DiaryPic {
    @NotBlank(message = "올바르지 않은 사진 형식입니다.")
    @Schema(description = "사진")
    private String pic;
    @JsonIgnore
    @Schema(defaultValue = "0")
    private int diaryId;
}
