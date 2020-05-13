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
public enum GroupMemberStatusExtensionEnum
{
    MEMBERSHIP_STATUS_JOINED("Pegacorn.FHIR.R1.ReferenceValues.Group.MembershipStatusEnum.JOINED"),
    MEMBERSHIP_STATUS_LEFT("Pegacorn.FHIR.R1.ReferenceValues.Group.MembershipStatusEnum.LEFT"),
    MEMBERSHIP_STATUS_MEMBER("Pegacorn.FHIR.R1.ReferenceValues.Group.MembershipStatusEnum.MEMBER"),
    MEMBERSHIP_STATUS_BANNED("Pegacorn.FHIR.R1.ReferenceValues.Group.MembershipStatusEnum.BANNED"),
    MEMBERSHIP_STATUS_INVITED("Pegacorn.FHIR.R1.ReferenceValues.Group.MembershipStatusEnum.INVITED");
    
    private String membershipStatus;
    
    private GroupMemberStatusExtensionEnum(String newNembershipStatus ){
        this.membershipStatus = newNembershipStatus;
    }
    
    public String getMembershipStatus(){
        return(this.membershipStatus);
    }
}
