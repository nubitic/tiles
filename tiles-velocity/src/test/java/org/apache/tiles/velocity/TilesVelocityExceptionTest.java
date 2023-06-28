/*
 * $Id: TilesVelocityExceptionTest.java 1035820 2010-11-16 21:26:24Z apetrelli $
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

package org.apache.tiles.velocity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests {@link TilesVelocityException}.
 *
 * @version $Rev: 1035820 $ $Date: 2010-11-17 08:26:24 +1100 (Wed, 17 Nov 2010) $
 */
public class TilesVelocityExceptionTest {

    /**
     * Test method for {@link TilesVelocityException#TilesVelocityException()}.
     */
    @Test
    public void testTilesVelocityException() {
        TilesVelocityException exception = new TilesVelocityException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link TilesVelocityException#TilesVelocityException(java.lang.String)}.
     */
    @Test
    public void testTilesVelocityExceptionString() {
        TilesVelocityException exception = new TilesVelocityException("my message");
        assertEquals("my message", exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link TilesVelocityException#TilesVelocityException(java.lang.Throwable)}.
     */
    @Test
    public void testTilesVelocityExceptionThrowable() {
        Throwable cause = new Throwable();
        TilesVelocityException exception = new TilesVelocityException(cause);
        assertEquals(cause.toString(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    /**
     * Test method for {@link TilesVelocityException#TilesVelocityException(java.lang.String, java.lang.Throwable)}.
     */
    @Test
    public void testTilesVelocityExceptionStringThrowable() {
        Throwable cause = new Throwable();
        TilesVelocityException exception = new TilesVelocityException("my message", cause);
        assertEquals("my message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}
