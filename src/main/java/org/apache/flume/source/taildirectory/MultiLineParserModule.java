/***************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ****************************************************************/
package org.apache.flume.source;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.flume.Context;
import org.apache.flume.conf.Configurable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class MultiLineParserModule implements Configurable,
    DirectoryTailParserModulable {
  private static final Logger logger = LoggerFactory
      .getLogger(MultiLineParserModule.class);

  private static final String CONFIG_FIRST_LINE_PATTERN = "first-line-pattern";
  private Pattern pattern;
  private String patternString;

  public void flush() {
  }

  public void parse(String line, FileSet header) {
  }

  public boolean isFirstLine(String line) {
    Matcher matcher = pattern.matcher(line);

    return matcher.find();
  }

  public boolean isLastLine(String line) {
    return false;
  }

  public void configure(Context context) {
    patternString = context.getString(CONFIG_FIRST_LINE_PATTERN);
    Preconditions.checkState(patternString != null,
        "Configuration must specify first-line-pattern.");

    try {
      pattern = Pattern.compile(patternString);
    } catch (PatternSyntaxException e) {
      Preconditions.checkState(pattern != null, e.getMessage());
      logger.error(e.getMessage(), e);
      return;
    }
  }
}
