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

package org.apache.tiles.velocity.template;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.servlet.context.ServletUtil;
import org.apache.tiles.template.AddListAttributeModel;
import org.apache.tiles.velocity.context.VelocityUtil;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.Renderable;

/**
 * Wraps {@link AddListAttributeModel} to be used in Velocity. For the list of
 * parameters, see
 * {@link AddListAttributeModel#start(java.util.Stack, String)}
 * and {@link AddListAttributeModel#end(java.util.Stack)}.
 * 
 * @version $Rev$ $Date$
 * @since 2.2.0
 */
public class AddListAttributeVModel implements BodyExecutable {

    /**
     * The template model.
     */
    private AddListAttributeModel model;
    
    /**
     * Constructor.
     * 
     * @param model The template model.
     * @since 2.2.0
     */
    public AddListAttributeVModel(AddListAttributeModel model) {
        this.model = model;
    }
    
    /** {@inheritDoc} */
    public Renderable end(HttpServletRequest request, HttpServletResponse response,
            Context velocityContext) {
        model.end(ServletUtil.getComposeStack(request));
        return VelocityUtil.EMPTY_RENDERABLE;
    }

    /** {@inheritDoc} */
    public void start(HttpServletRequest request, HttpServletResponse response,
            Context velocityContext, Map<String, Object> params) {
        model.start(ServletUtil.getComposeStack(request), (String) params.get("role"));
    }
}