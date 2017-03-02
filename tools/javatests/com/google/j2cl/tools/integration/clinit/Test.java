/*
 * Copyright 2015 Google Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */
package com.google.j2cl.tools.integration.clinit;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import junit.framework.TestCase;

/**
 * Test that $clinit is called by static native methods.
 */
class Test extends TestCase {

  @JsProperty(namespace = JsPackage.GLOBAL, name = "window.clinitCalled")
  public static native boolean isClinitCalled();

  public void testClinitMethodCalledByStaticNativeMethod() {
    assertNull(isClinitCalled());
    Main.staticNativeMethod();
    assertTrue(isClinitCalled());
  }
}
