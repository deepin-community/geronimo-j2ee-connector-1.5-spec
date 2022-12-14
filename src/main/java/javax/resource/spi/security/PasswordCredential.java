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

package javax.resource.spi.security;

import java.io.Serializable;
import java.util.Arrays;
import javax.resource.spi.ManagedConnectionFactory;

/**
 * @version $Rev: 467553 $ $Date: 2006-10-25 06:01:51 +0200 (Wed, 25 Oct 2006) $
 */
public final class PasswordCredential implements Serializable {
    private String userName;
    private char[] password;
    private ManagedConnectionFactory mcf;

    public PasswordCredential(String userName, char[] password) {
        this.userName = userName;
        this.password = (char[]) password.clone();
    }

    public String getUserName() {
        return userName;
    }

    public char[] getPassword() {
        return (char[]) password.clone();
    }

    public ManagedConnectionFactory getManagedConnectionFactory() {
        return mcf;
    }

    public void setManagedConnectionFactory(ManagedConnectionFactory mcf) {
        this.mcf = mcf;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PasswordCredential)) return false;

        final PasswordCredential credential = (PasswordCredential) o;

        if (!Arrays.equals(password, credential.password)) return false;
        if (!userName.equals(credential.userName)) return false;

        return true;
    }

    public int hashCode() {
        //@todo fix this
        int result = userName.hashCode();
        for (int i=0; i<password.length; i++) {
            result *= password[i];
        }
        return result;
    }
}