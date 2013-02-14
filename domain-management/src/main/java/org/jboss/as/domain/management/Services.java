/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.domain.management;

import java.util.concurrent.ScheduledExecutorService;

import org.jboss.msc.inject.Injector;
import org.jboss.msc.service.ServiceBuilder;
import org.jboss.msc.service.ServiceName;

/**
 * Utility methods related to service integration.
 *
 * @author Brian Stansberry (c) 2012 Red Hat Inc.
 */
public final class Services {

    private static final ServiceName EXECUTOR_SERVICE_NAME = ServiceName.JBOSS.append("server", "controller", "management", "scheduled-executor");

    public static ServiceName getDomainManagementExecutorServiceName() {
        return EXECUTOR_SERVICE_NAME;
    }

    public static void addDomainManagementExecutorServiceDependency(ServiceBuilder<?> builder, Injector<ScheduledExecutorService> injector) {
        builder.addDependency(getDomainManagementExecutorServiceName(), ScheduledExecutorService.class, injector);
    }

    private Services() {
        // no-op
    }
}
