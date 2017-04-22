package com.google.j2cl.transpiler.regression.compiler;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests the new JDK 1.5 enhanced for loop. */
@RunWith(JUnit4.class)
public class EnhancedForLoopTest {

  @Test
  public void testArray() {
    String[] items = new String[] {"1", "2", "3", "4", "5"};
    List<String> out = new ArrayList<String>();
    for (String i : items) {
      out.add(i);
    }
    assertThat(out.equals(Arrays.asList(items))).isTrue();
  }

  @Test
  public void testBoxing() {
    List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> out = new ArrayList<Integer>();
    for (int i : items) {
      out.add(i);
    }
    assertThat(out.equals(items)).isTrue();

    // Tests auto-unboxing.
    List<Long> itemsL = Arrays.asList(1L, 2L, 3L, 4L, 5L);
    List<Long> outL = new ArrayList<Long>();
    for (long l : items) {
      outL.add(l);
    }
    assertThat(outL.equals(itemsL)).isTrue();

    int[] unboxedItems = new int[] {1, 2, 3, 4, 5};
    out.clear();

    for (Integer i : unboxedItems) {
      out.add(i);
    }

    // Tests auto-boxing.
    for (int i = 0; i < 5; ++i) {
      assertThat(out.get(i).intValue() == unboxedItems[i]).isTrue();
    }
  }

  @Test
  public void testIterable() {
    Iterable<Integer> it = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> out = new ArrayList<Integer>();
    for (Integer i : it) {
      out.add(i);
    }
    assertThat(it.equals(out)).isTrue();
  }

  @Test
  public void testList() {
    List<String> items = Arrays.asList("1", "2", "3", "4", "5");
    List<String> out = new ArrayList<String>();
    for (String i : items) {
      out.add(i);
    }
    assertThat(out.equals(items)).isTrue();
  }
}