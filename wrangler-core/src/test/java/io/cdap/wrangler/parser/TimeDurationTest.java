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
//package io.cdap.directives.parser;
package io.cdap.wrangler.api.parser;

import io.cdap.wrangler.api.parser.TimeDuration;
import org.junit.Assert;
import org.junit.Test;

public class TimeDurationTest {

    @Test
    public void testMilliseconds() {
        TimeDuration t = new TimeDuration("250ms");
        Assert.assertEquals(250, t.getMilliseconds());
    }

    @Test
    public void testSeconds() {
        TimeDuration t = new TimeDuration("2s");
        Assert.assertEquals(2000, t.getMilliseconds());
    }

    @Test
    public void testFloatSeconds() {
        TimeDuration t = new TimeDuration("1.5s");
        Assert.assertEquals(1500, t.getMilliseconds());
    }
}
