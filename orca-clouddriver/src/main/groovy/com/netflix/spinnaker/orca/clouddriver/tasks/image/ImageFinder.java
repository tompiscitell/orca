/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.clouddriver.tasks.image;

import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ImageFinder {
  Collection<ImageDetails> byTags(
      StageExecution stage,
      String packageName,
      Map<String, String> tags,
      List<String> warningsCollector);

  String getCloudProvider();

  interface ImageDetails {
    String getImageId();

    String getImageName();

    String getRegion();

    JenkinsDetails getJenkins();
  }

  class JenkinsDetails extends HashMap<String, String> {
    public JenkinsDetails(String host, String name, String number) {
      put("host", host);
      put("name", name);
      put("number", number);
    }
  }
}
