/*
 * $Id: ModularTilesListenerTest.java 819199 2009-09-26 19:45:14Z apetrelli $
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

package org.apache.tiles.extras.module;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests {@link ModularTilesListener}.
 *
 * @version $Rev: 819199 $ $Date: 2009-09-27 05:45:14 +1000 (Sun, 27 Sep 2009) $
 */
public class ModularTilesListenerTest {

    /**
     * Test method for
     * {@link org.apache.tiles.extras.complete.ModularTilesListener#createTilesInitializer()}
     * .
     */
    @Test
    public void testCreateTilesInitializer() {
        ModularTilesListener listener = new ModularTilesListener();
        assertTrue(listener.createTilesInitializer() instanceof ModularTilesInitializer);
    }
}
