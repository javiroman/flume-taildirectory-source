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

import java.util.List;
import java.util.Map;

import org.apache.flume.conf.Configurable;

/**
 * <PRE>
 * 1. ClassName : 
 * 2. FileName  : DirectoyTailModulable.java
 * 3. Package  : kr.co.cplanet.logcollector.flumeng.source
 * 4. Comment  : 
 * 5. @author  : Jinoos Lee <jinoos@gmail.com>
 * 6. 작성일   : 2013. 10. 25. 오전 12:51:16
 * </PRE>
 */
public interface DirectoryTailParserModulable extends Configurable {
  public void flush();

  public void parse(String line, FileSet header);

  public boolean isFirstLine(String line);

  public boolean isLastLine(String line);
}
