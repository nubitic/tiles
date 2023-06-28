/*
 * $Id: CompareUtilTest.java 832082 2009-11-02 20:00:46Z apetrelli $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.tiles;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests {@link CompareUtil}.
 *
 * @version $Rev: 832082 $ $Date: 2009-11-03 07:00:46 +1100 (Tue, 03 Nov 2009) $
 */
public class CompareUtilTest {

    /**
     * A test value.
     */
    private static final Integer TEST_VALUE = 10;

    /**
     * Test method for {@link org.apache.tiles.CompareUtil#nullSafeEquals(java.lang.Object, java.lang.Object)}.
     */
    @Test
    public void testNullSafeEquals() {
        assertTrue(CompareUtil.nullSafeEquals(1, 1));
        assertFalse(CompareUtil.nullSafeEquals(1, 2));
        assertFalse(CompareUtil.nullSafeEquals(1, null));
        assertFalse(CompareUtil.nullSafeEquals(null, 1));
        assertTrue(CompareUtil.nullSafeEquals(null, null));
    }

    /**
     * Test method for {@link org.apache.tiles.CompareUtil#nullSafeHashCode(java.lang.Object)}.
     */
    @Test
    public void testNullSafeHashCode() {
        assertEquals(TEST_VALUE.hashCode(), CompareUtil.nullSafeHashCode(TEST_VALUE));
        assertEquals(0, CompareUtil.nullSafeHashCode(null));
    }
}
