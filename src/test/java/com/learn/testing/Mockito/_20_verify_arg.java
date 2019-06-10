package com.learn.testing.Mockito;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class _20_verify_arg {
    private ArrayList list = new ArrayList<>();

    @Before
    public void setUp(){
        this.list = new ArrayList<>();
    }

    @Test
    public void test_addAll() {
        Collection<String> collections = mock(Collection.class);
        when(collections.toArray()).thenReturn(new String[]{"A", "B", "C"});
        when(collections.iterator()).thenReturn(Arrays.asList("A", "B", "C").iterator());

        list.addAll(collections);

        verify(collections).toArray();
        verify(collections).iterator();
    }
}
