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
package net.fhirbox.pegacorn.fhir.r4.model.GroupPERHelpers;

/**
 *
 * @author Mark A. Hunter (ACT Health)
 * @since 2020-05-09
 */
public enum GroupPERJoinRuleStatusExtensionEnum
{
    JOINRULE_STATUS_PUBLIC("Pegacorn.FHIR.R4.Group.JoinRule.PUBLIC"),
    JOINRULE_STATUS_KNOCK("Pegacorn.FHIR.R4.Group.JoinRule.KNOCK"),
    JOINRULE_STATUS_INVITE("Pegacorn.FHIR.R4.Group.JoinRule.INVITE"),
    JOINRULE_STATUS_PRIVATE("Pegacorn.FHIR.R4.Group.JoinRule.PRIVATE");
    
    private String joinruleStatus;
    
    private GroupPERJoinRuleStatusExtensionEnum(String newJoinRuleStatus ){
        this.joinruleStatus = newJoinRuleStatus;
    }
    
    public String getJoinRuleStatus(){
        return(this.joinruleStatus);
    }
}
