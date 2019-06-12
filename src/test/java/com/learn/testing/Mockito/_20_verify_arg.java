package com.learn.testing.Mockito;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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
        when(collections.iterator()).thenReturn(asList("A", "B", "C").iterator());

        collections.size();
        list.addAll(collections);
        list.addAll(collections);
        list.addAll(collections);

        assertThat(list, equalTo(asList("A", "B", "C", "A", "B", "C", "A", "B", "C")));
        verify(collections, times(1)).size();
        verify(collections, times(3)).toArray();
        verifyNoMoreInteractions(collections);
    }
}
