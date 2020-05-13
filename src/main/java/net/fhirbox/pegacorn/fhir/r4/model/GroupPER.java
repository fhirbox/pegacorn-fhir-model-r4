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
package net.fhirbox.pegacorn.fhir.r4.model;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.parser.IParser;
import java.util.Iterator;
import net.fhirbox.pegacorn.fhir.r4.model.GroupPERHelpers.GroupPERExtensionSetException;
import net.fhirbox.pegacorn.fhir.r4.model.GroupPERHelpers.GroupPERExtensionMeanings;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Group;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.UriType;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ACT Health
 */
@ResourceDef(name = "GroupPER", profile = "http://hl7.org/fhir/profiles/custom-resource")
public class GroupPER extends Group
{

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(GroupPER.class);
    private static final GroupPERExtensionMeanings pegacornGroupExtensionMeanings = new GroupPERExtensionMeanings();

    @Override
    public GroupPER copy()
    {
        GroupPER retVal = new GroupPER();
        super.copyValues(retVal);
        return (retVal);
    }

    public GroupPER()
    {
        super();
        FhirContext ctx = FhirContext.forR4();
        ctx.registerCustomType(GroupPER.class);
    }

    // Predecessor Room Accessor Methods
    public boolean hasPredecessorGroup()
    {
        LOG.debug("hasPredecessorGroup(): Entry, checking Group Resource for Predecessor Group extension");
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupPredecessorExtensionMeaning())) {
            LOG.debug("hasPredecessorGroup(): Exit, has the -group_predecssor_group- extension");
            return (true);
        }
        LOG.debug("hasPredecessorGroup(): Exit, does not have the -group_predecssor_group- extension");
        return (false);
    }

    public Reference getPredecessorGroup()
            throws GroupPERExtensionSetException
    {
        LOG.debug("hasPredecessorGroup(): Entry, getting Predesessor Group");
        if (!hasPredecessorGroup()) {
            throw (new GroupPERExtensionSetException("getPredecessorGroup(): There is no Federation Status Extension"));
        }
        LOG.trace("getPredecessorGroup(): Extracting the appropriate Extension");
        Extension groupExtension = this.getExtensionByUrl(pegacornGroupExtensionMeanings.getGroupPredecessorExtensionMeaning());
        LOG.trace("getPredecessorGroup(): Check the Value, ensure it is the appropriate Type (Reference)");
        if (!(groupExtension.getValue() instanceof Reference)) {
            throw (new GroupPERExtensionSetException("getPredecessorGroup(): Group contains the wrong extension value type (not Reference)"));
        }
        LOG.trace("getPredecessorGroup(): Extract the Value from the Exension");
        Reference extractedPredecessorGroup = (Reference) (groupExtension.getValue());
        LOG.debug("getPredecessorGroup(): Exit, returning the Predecessor Group --> {}", extractedPredecessorGroup);
        return (extractedPredecessorGroup);
    }

    public void setPredecessorGroup(Reference previousGroup)
    {
        LOG.debug("setPredecessorGroup(): Entry, setting Previous Group to --> {}", previousGroup);
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupPredecessorExtensionMeaning())) {
            LOG.trace("setJoinRule(): removing existing Extension");
            this.removeExtension(pegacornGroupExtensionMeanings.getGroupPredecessorExtensionMeaning());
        }
        LOG.trace("setPredecessorGroup(): Creating new Predecessor Group Extension");
        Extension newPreviousGroupExtension = new Extension();
        newPreviousGroupExtension.setUrl(pegacornGroupExtensionMeanings.getGroupPredecessorExtensionMeaning());
        newPreviousGroupExtension.setValue(previousGroup);
        LOG.trace("setPredecessorGroup(): Injecting the Extension into Group");
        this.addExtension(newPreviousGroupExtension);
        LOG.debug("setPredecessorGroup(): Exit, added new Predecessor Group --> {}", newPreviousGroupExtension);
    }

    // Join Rule Accessor Methods
    public boolean hasJoinRule()
    {
        LOG.debug("hasJoinRule(): Entry, checking groupResource for JoinRule extension");
        if (this.hasExtension(pegacornGroupExtensionMeanings.getJoinRuleExtensionMeaning())) {
            LOG.debug("hasJoinRule(): Exit, has the -join_rule- extension");
            return (true);
        }
        LOG.debug("hasJoinRule(): Exit, does not have the -join_rule- extension");
        return (false);
    }

    public Integer getJoinRule()
            throws GroupPERExtensionSetException
    {
        LOG.debug("getJoinRule(): Entry, getting GroupPriority");
        if (!hasJoinRule()) {
            throw (new GroupPERExtensionSetException("getGroupPriority(): There is no GroupPriority Extension"));
        }
        LOG.trace("getJoinRule(): Extracting the appropriate Extension");
        Extension groupPriorityExtensionSet = this.getExtensionByUrl(pegacornGroupExtensionMeanings.getJoinRuleExtensionMeaning());
        LOG.trace("getJoinRule(): Check the Value, ensure it is the appropriate Type (IntegerType");
        if (!(groupPriorityExtensionSet.getValue() instanceof IntegerType)) {
            throw (new GroupPERExtensionSetException("getGroupPriority(): Group contains the wrong Group Priority extension value type"));
        }
        LOG.trace("getJoinRule(): Extract the Value from the Exension & convert to plain Integer");
        IntegerType extractedPriorityIntegerType = (IntegerType) (groupPriorityExtensionSet.getValue());
        Integer groupPriority = extractedPriorityIntegerType.getValue();
        LOG.debug("getJoinRule(): Exit, returning the Group Priority --> {}", groupPriority);
        return (groupPriority);
    }

    public void setJoinRule(Integer newPriority)
    {
        LOG.debug("setJoinRule(): Entry, setting GroupPriority to --> {}", newPriority);
        if (this.hasExtension(pegacornGroupExtensionMeanings.getJoinRuleExtensionMeaning())) {
            LOG.trace("setJoinRule(): removing existing Extension");
            this.removeExtension(pegacornGroupExtensionMeanings.getJoinRuleExtensionMeaning());
        }
        LOG.trace("setJoinRule(): Creating new GroupPriority Extension");
        Extension newGroupPriorityExtension = new Extension();
        newGroupPriorityExtension.setUrl(pegacornGroupExtensionMeanings.getJoinRuleExtensionMeaning());
        newGroupPriorityExtension.setValue(new IntegerType(newPriority));
        LOG.trace("setJoinRule(): Injecting the Extension into Group");
        this.addExtension(newGroupPriorityExtension);
        LOG.debug("setJoinRule(): Exit, added new Group Priority --> {}", newGroupPriorityExtension);
    }

    // Group Priority Accessor Methods
    public boolean hasGroupPriority()
    {
        LOG.debug("hasGroupPriority(): Entry, checking groupResource for GroupPriority extension");
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupPriorityExtensionMeaning())) {
            LOG.debug("hasGroupPriorty(): Exit, has the -group_priority- extension");
            return (true);
        }
        LOG.debug("hasGroupPriority(): Exit, does not have the -group_priority- extension");
        return (false);
    }

    public Integer getGroupPriority()
            throws GroupPERExtensionSetException
    {
        LOG.debug("getGroupPriority(): Entry, getting GroupPriority");
        if (!hasGroupPriority()) {
            throw (new GroupPERExtensionSetException("getGroupPriority(): There is no GroupPriority Extension"));
        }
        LOG.trace("getGroupPriority(): Extracting the appropriate Extension");
        Extension groupPriorityExtensionSet = this.getExtensionByUrl(pegacornGroupExtensionMeanings.getGroupPriorityExtensionMeaning());
        LOG.trace("getGroupPriority(): Check the Value, ensure it is the appropriate Type (IntegerType");
        if (!(groupPriorityExtensionSet.getValue() instanceof IntegerType)) {
            throw (new GroupPERExtensionSetException("getGroupPriority(): Group contains the wrong Group Priority extension value type"));
        }
        LOG.trace("getGroupPriority(): Extract the Value from the Exension & convert to plain Integer");
        IntegerType extractedPriorityIntegerType = (IntegerType) (groupPriorityExtensionSet.getValue());
        Integer groupPriority = extractedPriorityIntegerType.getValue();
        LOG.debug("getGroupPriority(): Exit, returning the Group Priority --> {}", groupPriority);
        return (groupPriority);
    }

    public void setGroupPriority(Integer newPriority)
    {
        LOG.debug("setGroupPriority(): Entry, setting GroupPriority to --> {}", newPriority);
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupPriorityExtensionMeaning())) {
            LOG.trace("setGroupPriority(): removing existing Extension");
            this.removeExtension(pegacornGroupExtensionMeanings.getGroupPriorityExtensionMeaning());
        }
        LOG.trace("setGroupPriority(): Creating new GroupPriority Extension");
        Extension newGroupPriorityExtension = new Extension();
        newGroupPriorityExtension.setUrl(pegacornGroupExtensionMeanings.getGroupPriorityExtensionMeaning());
        newGroupPriorityExtension.setValue(new IntegerType(newPriority));
        LOG.trace("setGroupPriority(): Injecting the Extension into Group");
        this.addExtension(newGroupPriorityExtension);
        LOG.debug("setGroupPriority(): Exit, added new Group Priority --> {}", newGroupPriorityExtension);
    }

    // Chat Group Version Accessor Methods
    public boolean hasChatGroupVersion()
    {
        LOG.debug("hasChatGroupVersion(): Entry, checking Group Resource for Predecessor Group extension");
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupChatGroupVersionExtensionMeaning())) {
            LOG.debug("hasPredecessorGroup(): Exit, has the -group_room_version- extension");
            return (true);
        }
        LOG.debug("hasChatGroupVersion(): Exit, does not have the -group_room_version- extension");
        return (false);
    }

    public Integer getChatGroupVersion()
            throws GroupPERExtensionSetException
    {
        LOG.debug("getChatGroupVersion(): Entry, getting Predesessor Group");
        if (!hasChatGroupVersion()) {
            throw (new GroupPERExtensionSetException("getPredecessorGroup(): There is no Group Chat Version Extension"));
        }
        LOG.trace("getChatGroupVersion(): Extracting the appropriate Extension");
        Extension groupExtension = this.getExtensionByUrl(pegacornGroupExtensionMeanings.getGroupChatGroupVersionExtensionMeaning());
        LOG.trace("getChatGroupVersion(): Check the Value, ensure it is the appropriate Type (IntegerType)");
        if (!(groupExtension.getValue() instanceof Reference)) {
            throw (new GroupPERExtensionSetException("getChatGroupVersion(): Group contains the wrong extension value type (not IntegerType)"));
        }
        LOG.trace("getChatGroupVersion(): Extract the Value from the Exension");
        IntegerType extractedGroupChatVersion = (IntegerType) (groupExtension.getValue());
        LOG.debug("getChatGroupVersion(): Exit, returning the Chat Group Version --> {}", extractedGroupChatVersion);
        return (extractedGroupChatVersion.getValue());
    }

    public void setChatGroupVersion(Integer chatGroupVersion)
    {
        LOG.debug("setChatGroupVersion(): Entry, setting Chat Group Version to --> {}", chatGroupVersion);
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupChatGroupVersionExtensionMeaning())) {
            LOG.trace("setChatGroupVersion(): removing existing Extension");
            this.removeExtension(pegacornGroupExtensionMeanings.getGroupChatGroupVersionExtensionMeaning());
        }
        LOG.trace("setChatGroupVersion(): Creating new Chat Group Version Extension");
        Extension newChatGroupVersionExtension = new Extension();
        newChatGroupVersionExtension.setUrl(pegacornGroupExtensionMeanings.getGroupPredecessorExtensionMeaning());
        newChatGroupVersionExtension.setValue(new IntegerType(chatGroupVersion));
        LOG.trace("setChatGroupVersion(): Injecting the Extension into Group");
        this.addExtension(newChatGroupVersionExtension);
        LOG.debug("setChatGroupVersion(): Exit, added new Chat Group Version --> {}", newChatGroupVersionExtension);
    }

    // Chat Group Version Accessor Methods
    public boolean hasPreviousGroupLastMessage()
    {
        LOG.debug("hasPreviousGroupLastMessage(): Entry, checking Group Resource for Predecessor Group Last Message extension");
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupPredecessorLastMessageExtensionMeaning())) {
            LOG.debug("hasPreviousGroupLastMessage(): Exit, does  have the -group_predecessor_room_last_message- extension");
            return (true);
        }
        LOG.debug("hasPreviousGroupLastMessage(): Exit, does not have the -group_predecessor_room_last_message- extension");
        return (false);
    }

    public Reference getPreviousGroupLastMessage()
            throws GroupPERExtensionSetException
    {
        LOG.debug("getPreviousGroupLastMessage(): Entry, getting Predesessor Group Last Message");
        if (!hasPreviousGroupLastMessage()) {
            throw (new GroupPERExtensionSetException("getPreviousGroupLastMessage(): There is no Previous Group Last Message Extension"));
        }
        LOG.trace("getPreviousGroupLastMessage(): Extracting the appropriate Extension");
        Extension groupExtension = this.getExtensionByUrl(pegacornGroupExtensionMeanings.getGroupPredecessorLastMessageExtensionMeaning());
        LOG.trace("getPreviousGroupLastMessage(): Check the Value, ensure it is the appropriate Type (Reference)");
        if (!(groupExtension.getValue() instanceof Reference)) {
            throw (new GroupPERExtensionSetException("getChatGroupVersion(): Group contains the wrong extension value type (not Reference)"));
        }
        LOG.trace("getPreviousGroupLastMessage(): Extract the Value from the Exension");
        Reference extractedPreviousGroupLastMessageReference = (Reference) (groupExtension.getValue());
        LOG.debug("getPreviousGroupLastMessage(): Exit, returning the Previous Group Last Message Extension --> {}", extractedPreviousGroupLastMessageReference);
        return (extractedPreviousGroupLastMessageReference);
    }

    public void setPreviousGroupLastMessage(Reference previousGroupLastMessage)
    {
        LOG.debug("setPreviousGroupLastMessage(): Entry, setting Chat Group Version to --> {}", previousGroupLastMessage);
        if (this.hasExtension(pegacornGroupExtensionMeanings.getGroupPredecessorLastMessageExtensionMeaning())) {
            LOG.trace("setPreviousGroupLastMessage(): removing existing Extension");
            this.removeExtension(pegacornGroupExtensionMeanings.getGroupPredecessorLastMessageExtensionMeaning());
        }
        LOG.trace("setPreviousGroupLastMessage(): Creating new Chat Group Version Extension");
        Extension newPreviousGroupLastMessageExtension = new Extension();
        newPreviousGroupLastMessageExtension.setUrl(pegacornGroupExtensionMeanings.getGroupPredecessorLastMessageExtensionMeaning());
        newPreviousGroupLastMessageExtension.setValue(previousGroupLastMessage);
        LOG.trace("setPreviousGroupLastMessage(): Injecting the Extension into Group");
        this.addExtension(newPreviousGroupLastMessageExtension);
        LOG.debug("setPreviousGroupLastMessage(): Exit, added new Previous Group Last Message Extension --> {}", newPreviousGroupLastMessageExtension);
    }

    // Canonical Alias Accessor Methods
    public boolean hasCanonicalAlias()
    {
        LOG.debug("hasCanonicalAlias(): Entry, checking groupResource for Canonical Alias extension");
        if (this.hasExtension(pegacornGroupExtensionMeanings.getJoinRuleExtensionMeaning())) {
            LOG.debug("hasCanonicalAlias(): Exit, has the -canonical_alias- extension");
            return (true);
        }
        LOG.debug("hasJoinRule(): Exit, does not have the -canonical_alias- extension");
        return (false);
    }

    public Identifier getCanonicalAlias()
            throws GroupPERExtensionSetException
    {
        LOG.debug("getCanonicalAlias(): Entry, getting Canonical Alias");
        if (!hasCanonicalAlias()) {
            throw (new GroupPERExtensionSetException("getCanonicalAlias(): There is no Canonical Alias Extension"));
        }
        LOG.trace("getCanonicalAlias(): Extracting the appropriate Extension");
        Extension groupPriorityExtensionSet = this.getExtensionByUrl(pegacornGroupExtensionMeanings.getCanonicalAliasExtensionMeaning());
        LOG.trace("getCanonicalAlias(): Check the Value, ensure it is the appropriate Type (Identifier)");
        if (!(groupPriorityExtensionSet.getValue() instanceof Identifier)) {
            throw (new GroupPERExtensionSetException("getCanonicalAlias(): Group contains the wrong Canonical Alias extension value type"));
        }
        LOG.trace("getCanonicalAlias(): Extract the Value from the Exension");
        Identifier extractedCanonicalAlias = (Identifier) (groupPriorityExtensionSet.getValue());
        LOG.debug("getCanonicalAlias(): Exit, returning the Canonical Alias --> {}", extractedCanonicalAlias);
        return (extractedCanonicalAlias);
    }

    public void setCanonicalAlias(Identifier canonicalAlias)
    {
        LOG.debug("setCanonicalAlias(): Entry, setting Canonical Alias to --> {}", canonicalAlias);
        if (this.hasExtension(pegacornGroupExtensionMeanings.getCanonicalAliasExtensionMeaning())) {
            LOG.trace("setCanonicalAlias(): removing existing Extension");
            this.removeExtension(pegacornGroupExtensionMeanings.getCanonicalAliasExtensionMeaning());
        }
        LOG.trace("setCanonicalAlias(): Creating new Canonical Alias Extension");
        Extension newCanonicalAliasExtension = new Extension();
        newCanonicalAliasExtension.setUrl(pegacornGroupExtensionMeanings.getCanonicalAliasExtensionMeaning());
        newCanonicalAliasExtension.setValue(canonicalAlias);
        LOG.trace("setCanonicalAlias(): Injecting the Extension into Group");
        this.addExtension(newCanonicalAliasExtension);
        LOG.debug("setCanonicalAlias(): Exit, added new Canonical Alias --> {}", newCanonicalAliasExtension);
    }

    // Tooling
    public void removeExtension(String url)
    {
        Iterator<Extension> i = this.getExtension().iterator();
        while (i.hasNext()) {
            Extension e = i.next(); // must be called before you can call i.remove()
            if (e.getUrl().equals(url)) {
                i.remove();
            }
        }
    }

}
