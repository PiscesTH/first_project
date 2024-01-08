package com.clean.cleanssakssak.diary.model;

import com.clean.cleanssakssak.common.ListSizeConstraint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiaryInsDto {
    @JsonIgnore
    @Schema(title = "생성된 다이어리 pk")
    private int diaryId;

    @Positive
    @Schema(title = "로그인 한 유저pk")
    private int loginedUserId;

    @Schema(title = "다이어리 제목")
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @Schema(title = "다이어리 내용")
    private String contents;

    @Schema(title = "다이어리 사진들")
    @NotNull(message = "사진을 두 장 선택해주세요.")
    @Size(min = 2, max = 2, message = "사진 두장 필요")
    private List<@NotBlank(message = "올바르지 않은 사진 형식입니다.") String> pics;

}
