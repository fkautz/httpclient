/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.conn.util;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for InetAddressUtils.
 */
public class TestInetAddressUtils extends TestCase {

    public TestInetAddressUtils(String testName) {
        super(testName);
    }

    public static void main(String args[]) {
        String[] testCaseName = { TestInetAddressUtils.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }

    public static Test suite() {
        return new TestSuite(TestInetAddressUtils.class);
    }
    
    public void testValidIPv4Address() {
        assertTrue(InetAddressUtils.isIPv4Address("127.0.0.1"));
        assertTrue(InetAddressUtils.isIPv4Address("192.168.0.0"));
        assertTrue(InetAddressUtils.isIPv4Address("255.255.255.255"));
    }

    public void testInvalidIPv4Address() {
        assertFalse(InetAddressUtils.isIPv4Address(" 127.0.0.1 "));  // Blanks not allowed
        assertFalse(InetAddressUtils.isIPv4Address("g.ar.ba.ge"));
        assertFalse(InetAddressUtils.isIPv4Address("192.168.0"));
        assertFalse(InetAddressUtils.isIPv4Address("256.255.255.255"));
    }

    public void testValidIPv6Address() {
        assertTrue(InetAddressUtils.isIPv6StdAddress("2001:0db8:0000:0000:0000:0000:1428:57ab"));
        assertTrue(InetAddressUtils.isIPv6StdAddress("2001:db8:0:0:0:0:1428:57ab"));
        assertTrue(InetAddressUtils.isIPv6HexCompressedAddress("2001:0db8:0:0::1428:57ab"));
        assertTrue(InetAddressUtils.isIPv6HexCompressedAddress("2001:0db8::1428:57ab"));
        assertTrue(InetAddressUtils.isIPv6HexCompressedAddress("2001:db8::1428:57ab"));
    }

    public void testInvalidIPv6Address() {
        assertFalse(InetAddressUtils.isIPv6Address("2001:0db8:0000:garb:age0:0000:1428:57ab"));
        assertFalse(InetAddressUtils.isIPv6Address("2001:0gb8:0000:0000:0000:0000:1428:57ab"));
    }
    
}
