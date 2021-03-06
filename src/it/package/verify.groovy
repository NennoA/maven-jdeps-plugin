
/*
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
 */
 
def buildLog = new File( basedir, 'build.log' )

def lines = buildLog.readLines().dropWhile{ !it.startsWith("classes -> ") }.takeWhile{ !it.startsWith( '[INFO]' ) }

  // classes -> java.base
  //   org.apache.maven.plugins.jdeps.its                 -> java.io                                            java.base

  // classes -> c:\Program Files\Java\jdk1.8.0_152\jre\lib\rt.jar
  //   org.apache.maven.plugins.jdeps.its (classes)
  //      -> java.io  

assert lines.size() == ( lines[0] == 'classes -> java.base' ? 2 : 3  )
