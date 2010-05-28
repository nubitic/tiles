/*
 * $Id$
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
package org.apache.tiles.renderer.impl;

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import org.apache.tiles.Attribute;
import org.apache.tiles.evaluator.BasicAttributeEvaluatorFactory;
import org.apache.tiles.evaluator.impl.DirectAttributeEvaluator;
import org.apache.tiles.request.Request;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link AbstractBaseAttributeRenderer}.
 *
 * @version $Rev$ $Date$
 */
public class AbstractBaseAttributeRendererTest {

    /**
     * The renderer, no more abstract.
     */
    private MockAttributeRenderer renderer;

    /**
     * Sets up the test.
     */
    @Before
    public void setUp() {
        renderer = new MockAttributeRenderer();
        renderer
                .setAttributeEvaluatorFactory(new BasicAttributeEvaluatorFactory(
                        new DirectAttributeEvaluator()));
    }

    /**
     * Tests {@link AbstractBaseAttributeRenderer#render(Attribute, Request)}.
     *
     * @throws IOException If something goes wrong during rendition.
     */
    @Test
    public void testRender() throws IOException {
        Attribute attribute = new Attribute();
        StringWriter writer = new StringWriter();
        Request requestContext = createMock(Request.class);
        expect(requestContext.getWriter()).andReturn(writer);
        replay(requestContext);
        renderer.render(attribute, requestContext);
        writer.close();
        assertEquals("Wrongly written", "wrote", writer.toString());
        verify(requestContext);
    }

    /**
     * Tests {@link AbstractBaseAttributeRenderer#render(Attribute, Request)}.
     *
     * @throws IOException If something goes wrong during rendition.
     */
    @Test
    public void testRenderNotPermitted() throws IOException {
        Attribute attribute = new Attribute();
        Request requestContext = createMock(Request.class);
        attribute.setRole("first");

        expect(requestContext.isUserInRole("first")).andReturn(Boolean.FALSE);

        replay(requestContext);
        renderer.render(attribute, requestContext);
        verify(requestContext);
    }

    /**
     * Tests {@link AbstractBaseAttributeRenderer#isPermitted(Request, Set)}.
     */
    @Test
    public void testIsPermitted() {
        Request requestContext = createMock(Request.class);
        expect(requestContext.isUserInRole("first")).andReturn(Boolean.TRUE)
                .anyTimes();
        expect(requestContext.isUserInRole("second")).andReturn(Boolean.FALSE)
                .anyTimes();
        replay(requestContext);
        Set<String> roles = new HashSet<String>();
        roles.add("first");
        assertTrue("The role is not permitted", renderer.isPermitted(
                requestContext, roles));
        roles.clear();
        roles.add("second");
        assertFalse("The role is not permitted", renderer.isPermitted(
                requestContext, roles));
        verify(requestContext);
    }

    /**
     * The renderer with "write" implementation.
     */
    private static class MockAttributeRenderer extends
            AbstractBaseAttributeRenderer {

        /** {@inheritDoc} */
        @Override
        public void write(Object value, Attribute attribute, Request request)
                throws IOException {
            request.getWriter().write("wrote");
        }
    }
}
