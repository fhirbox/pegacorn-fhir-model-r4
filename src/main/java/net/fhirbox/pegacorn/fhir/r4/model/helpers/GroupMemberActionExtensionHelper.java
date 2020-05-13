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
package net.fhirbox.pegacorn.fhir.r4.model.helpers;

import java.util.List;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Group;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.UriType;

/**
 *
 * @author Mark A. Hunter (ACT Health)
 */
public class GroupMemberActionExtensionHelper
{

    private static UriType MEMBERSHIP_STATUS_MEANING = new UriType("http://www.fhirplace.net/pegacorn/FHIR/R4/Group/group_membership_status");

    public boolean hasMembershipStatusExention(Group.GroupMemberComponent membership)
    {
        if (membership.hasExtension(this.MEMBERSHIP_STATUS_MEANING.asStringValue())) {
            return (true);
        }
        return (false);
    }

    public GroupMemberActionExtensionEnum extractGroupMemberStatusExtension(Group.GroupMemberComponent membership)
            throws GroupExtensionSetException
    {
        if (!membership.hasExtension(this.MEMBERSHIP_STATUS_MEANING.asStringValue())) {
            throw (new GroupExtensionSetException("extractGroupMemberStatusExtension(): Group::member does not contain the GroupMemberStatus extension"));
        }
        Extension extractedStatusExtension = membership.getExtensionByUrl(MEMBERSHIP_STATUS_MEANING.asStringValue());
        if( !(extractedStatusExtension.getValue() instanceof StringType)){
            throw (new GroupExtensionSetException("extractGroupMemberStatusExtension(): Group::member contains the GroupMemberStatus extension value type"));
        }
        StringType extractedStatusStringType = (StringType) (extractedStatusExtension.getValue());
        GroupMemberActionExtensionEnum statusEnum = GroupMemberActionExtensionEnum.valueOf(extractedStatusStringType.getValue());
        return (statusEnum);
    }

    public void injectGroupMemberStatusExtension(Group.GroupMemberComponent membership, GroupMemberActionExtensionEnum newStatus){
        if (membership.hasExtension(this.MEMBERSHIP_STATUS_MEANING.asStringValue())) {
            membership.removeExtension(this.MEMBERSHIP_STATUS_MEANING.asStringValue());
        }
        Extension newStatusExtension = new Extension();
        newStatusExtension.setUrlElement(MEMBERSHIP_STATUS_MEANING);
        newStatusExtension.setValue(new StringType(newStatus.getMembershipStatus()));
    }
    
}
