/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//
// This source code implements specifications defined by the Java
// Community Process. In order to remain compliant with the specification
// DO NOT add / change / or delete method signatures!
//

package javax.resource.spi.work;

import java.util.EventObject;

/**
 * @version $Rev: 467553 $ $Date: 2006-10-25 06:01:51 +0200 (Wed, 25 Oct 2006) $
 */
public class WorkEvent extends EventObject {
    public static final int WORK_ACCEPTED = 1;
    public static final int WORK_REJECTED = 2;
    public static final int WORK_STARTED = 3;
    public static final int WORK_COMPLETED = 4;

    private int type;
    private Work work;
    private WorkException exception;
    private long startDuration = -1;

    public WorkEvent(Object source, int type, Work work, WorkException exc) {
        super(source);
        this.type = type;
        this.work = work;
        this.exception = exc;

    }

    public WorkEvent(Object source, int type, Work work, WorkException exc, long startDuration) {
        this(source, type, work, exc);
        this.startDuration = startDuration;
    }

    public int getType() {
        return type;
    }

    public Work getWork() {
        return work;
    }

    public long getStartDuration() {
        return startDuration;
    }

    public WorkException getException() {
        return exception;
    }
}