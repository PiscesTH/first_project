package com.clean.cleanssakssak.common;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class ,ValidationGroup.NotBlankGroup.class, ValidationGroup.PatternCheckGroup.class})
public interface ValidationSequence {
}
