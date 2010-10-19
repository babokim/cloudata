/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudata.core.common.io;

import java.io.*;
import java.util.*;

/** A Comparator for {@link CWritableComparable}s.
 *
 * <p>This base implemenation uses the natural ordering.  To define alternate
 * orderings, override {@link #compare(CWritableComparable,CWritableComparable)}.
 *
 * <p>One may optimize compare-intensive operations by overriding
 * {@link #compare(byte[],int,int,byte[],int,int)}.  Static utility methods are
 * provided to assist in optimized implementations of this method.
 */
public class CWritableComparator implements Comparator {

  private static HashMap<Class, CWritableComparator> comparators =
    new HashMap<Class, CWritableComparator>(); // registry

  /** Get a comparator for a {@link CWritableComparable} implementation. */
  public static synchronized CWritableComparator get(Class c) {
    CWritableComparator comparator = comparators.get(c);
    if (comparator == null)
      comparator = new CWritableComparator(c);
    return comparator;
  }

  /** Register an optimized comparator for a {@link CWritableComparable}
   * implementation. */
  public static synchronized void define(Class c,
                                         CWritableComparator comparator) {
    comparators.put(c, comparator);
  }


  private CDataInputBuffer buffer = new CDataInputBuffer();

  private Class keyClass;
  private CWritableComparable key1;
  private CWritableComparable key2;

  /** Construct for a {@link CWritableComparable} implementation. */
  protected CWritableComparator(Class keyClass) {
    this.keyClass = keyClass;
    this.key1 = newKey();
    this.key2 = newKey();
  }

  /** Returns the WritableComparable implementation class. */
  public Class getKeyClass() { return keyClass; }

  /** Construct a new {@link CWritableComparable} instance. */
  public CWritableComparable newKey() {
    try {
      return (CWritableComparable)keyClass.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  /** Optimization hook.  Override this to make SequenceFile.Sorter's scream.
   *
   * <p>The default implementation reads the data into two {@link
   * CWritableComparable}s (using {@link
   * CWritable#readFields(DataInput)}, then calls {@link
   * #compare(CWritableComparable,CWritableComparable)}.
   */
  public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
    try {
      buffer.reset(b1, s1, l1);                   // parse key1
      key1.readFields(buffer);
      
      buffer.reset(b2, s2, l2);                   // parse key2
      key2.readFields(buffer);
      
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    
    return compare(key1, key2);                   // compare them
  }

  /** Compare two WritableComparables.
   *
   * <p> The default implementation uses the natural ordering, calling {@link
   * Comparable#compareTo(Object)}. */
  @SuppressWarnings("unchecked")
  public int compare(CWritableComparable a, CWritableComparable b) {
    return a.compareTo(b);
  }

  public int compare(Object a, Object b) {
    return compare((CWritableComparable)a, (CWritableComparable)b);
  }

  /** Lexicographic order of binary data. */
  public static int compareBytes(byte[] b1, int s1, int l1,
                                 byte[] b2, int s2, int l2) {
    int end1 = s1 + l1;
    int end2 = s2 + l2;
    for (int i = s1, j = s2; i < end1 && j < end2; i++, j++) {
      int a = (b1[i] & 0xff);
      int b = (b2[j] & 0xff);
      if (a != b) {
        return a - b;
      }
    }
    return l1 - l2;
  }

  /** Compute hash for binary data. */
  public static int hashBytes(byte[] bytes, int length) {
    int hash = 1;
    for (int i = 0; i < length; i++)
      hash = (31 * hash) + (int)bytes[i];
    return hash;
  }

  /** Parse an unsigned short from a byte array. */
  public static int readUnsignedShort(byte[] bytes, int start) {
    return (((bytes[start]   & 0xff) <<  8) +
            ((bytes[start+1] & 0xff)));
  }

  /** Parse an integer from a byte array. */
  public static int readInt(byte[] bytes, int start) {
    return (((bytes[start  ] & 0xff) << 24) +
            ((bytes[start+1] & 0xff) << 16) +
            ((bytes[start+2] & 0xff) <<  8) +
            ((bytes[start+3] & 0xff)));

  }

  /** Parse a float from a byte array. */
  public static float readFloat(byte[] bytes, int start) {
    return Float.intBitsToFloat(readInt(bytes, start));
  }

  /** Parse a long from a byte array. */
  public static long readLong(byte[] bytes, int start) {
    return ((long)(readInt(bytes, start)) << 32) +
      (readInt(bytes, start+4) & 0xFFFFFFFFL);
  }

  /** Parse a double from a byte array. */
  public static double readDouble(byte[] bytes, int start) {
    return Double.longBitsToDouble(readLong(bytes, start));
  }

  /**
   * Reads a zero-compressed encoded long from a byte array and returns it.
   * @param bytes byte array with decode long
   * @param start starting index
   * @throws java.io.IOException 
   * @return deserialized long
   */
  public static long readVLong(byte[] bytes, int start) throws IOException {
    int len = bytes[start];
    if (len >= -112) {
      return len;
    }
    boolean isNegative = (len < -120);
    len = isNegative ? -(len + 120) : -(len + 112);
    if (start+1+len>bytes.length)
      throw new IOException(
                            "Not enough number of bytes for a zero-compressed integer");
    long i = 0;
    for (int idx = 0; idx < len; idx++) {
      i = i << 8;
      i = i | (bytes[start+1+idx] & 0xFF);
    }
    return (isNegative ? (i ^ -1L) : i);
  }
  
  /**
   * Reads a zero-compressed encoded integer from a byte array and returns it.
   * @param bytes byte array with the encoded integer
   * @param start start index
   * @throws java.io.IOException 
   * @return deserialized integer
   */
  public static int readVInt(byte[] bytes, int start) throws IOException {
    return (int) readVLong(bytes, start);
  }
}
