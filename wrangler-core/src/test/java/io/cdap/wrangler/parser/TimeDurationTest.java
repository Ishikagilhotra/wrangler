/*
 * Copyright © 2017-2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cdap.wrangler.api.parser;

import org.junit.Assert;
import org.junit.Test;

public class TimeDurationTest {

  @Test
  public void testMilliseconds() {
    TimeDuration t = new TimeDuration("250ms");
    Assert.assertEquals(250_000_000L, t.getNanoseconds());
  }

  @Test
  public void testSeconds() {
    TimeDuration t = new TimeDuration("2s");
    Assert.assertEquals(2_000_000_000L, t.getNanoseconds());
  }

  @Test
  public void testFloatSeconds() {
    TimeDuration t = new TimeDuration("1.5s");
    Assert.assertEquals(1_500_000_000L, t.getNanoseconds());
  }

  @Test
  public void testMinutes() {
    TimeDuration t = new TimeDuration("1m");
    Assert.assertEquals(60_000_000_000L, t.getNanoseconds());
  }

  @Test
  public void testHours() {
    TimeDuration t = new TimeDuration("1h");
    Assert.assertEquals(3_600_000_000_000L, t.getNanoseconds());
  }
}
