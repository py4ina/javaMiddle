package com.learn.testing.Mockito.habr;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DataServiceTest {

//    @Test
//    public void saveData() {
//        DataService dataService = mock(DataService.class);
//        List<String> data = new ArrayList<>();
//        data.add("dataItem");
//
////        when(dataService.getAllData()).thenReturn(data);
////        doReturn(data).when(dataService).getData();
////        when(dataService.getDataById(eq("1111")))
////                .thenReturn("11111111111111");
//        when(dataService.getDataListByIds(any()))
//                .thenAnswer(invocation -> invocation
//                        .<List<String>>getArgument(0).stream()
//                        .map(id -> {
//                            switch (id) {
//                                case "a":
//                                    return "dataItemA";
//                                case "b":
//                                    return "dataItemB";
//                                default:
//                                    return null;
//                            }
//                        }).collect(Collectors.toList()));
//    }

}