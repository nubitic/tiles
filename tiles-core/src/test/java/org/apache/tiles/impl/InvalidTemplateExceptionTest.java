/*
 * $Id: InvalidTemplateExceptionTest.java 943985 2010-05-13 19:30:49Z apetrelli $
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

package org.apache.tiles.impl;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests {@link InvalidTemplateException}.
 *
 * @version $Rev: 943985 $ $Date: 2010-05-14 05:30:49 +1000 (Fri, 14 May 2010) $
 */
public class InvalidTemplateExceptionTest {

    /**
     * Test method for {@link InvalidTemplateException#InvalidTemplateException()}.
     */
    @Test
    public void testInvalidTemplateException() {
        InvalidTemplateException exception = new InvalidTemplateException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link InvalidTemplateException#InvalidTemplateException(java.lang.String)}.
     */
    @Test
    public void testInvalidTemplateExceptionString() {
        InvalidTemplateException exception = new InvalidTemplateException("my message");
        assertEquals("my message", exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link InvalidTemplateException#InvalidTemplateException(java.lang.Throwable)}.
     */
    @Test
    public void testInvalidTemplateExceptionThrowable() {
        Throwable cause = new Throwable();
        InvalidTemplateException exception = new InvalidTemplateException(cause);
        assertEquals(cause.toString(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    /**
     * Test method for {@link InvalidTemplateException#InvalidTemplateException(java.lang.String, java.lang.Throwable)}.
     */
    @Test
    public void testInvalidTemplateExceptionStringThrowable() {
        Throwable cause = new Throwable();
        InvalidTemplateException exception = new InvalidTemplateException("my message", cause);
        assertEquals("my message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}
