package com.learn.testing.Mockito.habr;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class DataSearchRequest {
    String id;
    Date updatedBefore;
    int length;
}
