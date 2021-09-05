package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayFuncTest {
    private ArrayFunc tests;

    @Test
    public void doesWorksWithEmpty() throws Exception {
        int[] array = { };
        assertEquals(0, ArrayFunc.Accumulate(array));
    }

    @Test
    public void doesWorksWithNegative() throws Exception {
        int[] array = {-1, -2, -4, -6, -8};
        assertEquals(0, ArrayFunc.Accumulate(array));
    }

    @Test
    public void correctCalculating() throws Exception {
        int[] array = {-1, 2, 4, 6, 8, 0, 3, 1, 5};
        assertEquals(20, ArrayFunc.Accumulate(array));
    }

}