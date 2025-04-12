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
package io.cdap.directives.aggregates;

import io.cdap.wrangler.api.Row;
import io.cdap.wrangler.test.TestingRig;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AggregateStatsTest {

    @Test
    public void testAggregationLogic() throws Exception {
        // Input rows
        List<Row> rows = Arrays.asList(
            new Row("size_col", "1MB").add("time_col", "1.5s"),
            new Row("size_col", "512KB").add("time_col", "250ms")
        );

        // Recipe using your directive
        String[] recipe = new String[] {
            "aggregate-stats :size_col :time_col total_size_mb total_time_sec"
        };

        List<Row> results = TestingRig.execute(recipe, rows);

        Assert.assertEquals(1, results.size());
        Row result = results.get(0);

        // Assert aggregated values
        double expectedSizeMB = 1.5; // 1MB + 0.5MB
        double expectedTimeSec = 1.75; // 1.5s + 0.25s

        Assert.assertEquals(expectedSizeMB, (Double) result.getValue("total_size_mb"), 0.001);
        Assert.assertEquals(expectedTimeSec, (Double) result.getValue("total_time_sec"), 0.001);
    }
}
