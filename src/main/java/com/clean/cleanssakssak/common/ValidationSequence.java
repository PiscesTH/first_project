package com.clean.cleanssakssak.common;

import jakarta.validation.GroupSequence;

@GroupSequence({ValidationGroup.NotBlankGroup.class, ValidationGroup.PatternCheckGroup.class})
public interface ValidationSequence {
}
