package com.learn.testing.Mockito;

import java.util.List;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

public class _15_mock_types {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.iterator());

        System.out.println();

        List listDeepStub = mock(List.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS));
        System.out.println(listDeepStub.size());
        System.out.println(listDeepStub.isEmpty());
        System.out.println(listDeepStub.iterator());
        System.out.println(listDeepStub.iterator().hasNext());
        System.out.println(listDeepStub.iterator().next());
        System.out.println(listDeepStub.iterator());
        System.out.println(listDeepStub.subList(0, 10).get(0).toString());
    }
}
