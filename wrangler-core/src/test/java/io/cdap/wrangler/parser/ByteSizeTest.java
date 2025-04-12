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
import io.cdap.wrangler.api.parser.ByteSize;
import org.junit.Assert;
import org.junit.Test;

public class ByteSizeTest {

    @Test
    public void testKB() {
        ByteSize size = new ByteSize("1KB");
        Assert.assertEquals(1024, size.getBytes());
    }

    @Test
    public void testMB() {
        ByteSize size = new ByteSize("1MB");
        Assert.assertEquals(1024 * 1024, size.getBytes());
    }

    @Test
    public void testGB() {
        ByteSize size = new ByteSize("1GB");
        Assert.assertEquals(1024L * 1024 * 1024, size.getBytes());
    }

    @Test
    public void testFloatSize() {
        ByteSize size = new ByteSize("1.5MB");
        Assert.assertEquals(1572864, size.getBytes());
    }
}
