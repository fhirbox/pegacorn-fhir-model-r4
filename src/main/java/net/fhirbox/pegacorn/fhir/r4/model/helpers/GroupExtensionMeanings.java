/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fhirbox.pegacorn.fhir.r4.model.helpers;

import org.hl7.fhir.r4.model.UriType;

/**
 *
 * @author ACT Health
 */
public final class GroupExtensionMeanings
{
    private static final UriType GROUP_PRIORITY_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/group_priority");
    private static final UriType GROUP_JOINRULE_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/join_rule");
    private static final UriType GROUP_PREDECESSOR_GROUP_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/group_predecessor_group");
    private static final UriType GROUP_CHAT_GROUP_VERSION_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/group_room_version");
    private static final UriType GROUP_PREDECSSOR_ROOM_LAST_MESSAGE_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/group_predecessor_room_last_message");
    private static final UriType GROUP_CANONICAL_ALIAS_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/group_canonical_alias");
    private static final UriType GROUP_FEDERATION_STATUS_EXTENSION_MEANING = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Group/group_federation_status");

    public String getGroupPriorityExtensionMeaning(){return(GROUP_PRIORITY_EXTENSION_MEANING.asStringValue());}
    public String getJoinRuleExtensionMeaning(){return(GROUP_JOINRULE_EXTENSION_MEANING.asStringValue());}
    public String getGroupPredecessorExtensionMeaning(){return(GROUP_JOINRULE_EXTENSION_MEANING.asStringValue());}
    public String getGroupChatGroupVersionExtensionMeaning(){return(GROUP_CHAT_GROUP_VERSION_EXTENSION_MEANING.asStringValue());}
    public String getGroupPredecessorLastMessageExtensionMeaning(){return(GROUP_PREDECSSOR_ROOM_LAST_MESSAGE_EXTENSION_MEANING.asStringValue());}
    public String getCanonicalAliasExtensionMeaning(){return(GROUP_CANONICAL_ALIAS_EXTENSION_MEANING.asStringValue());}
    public String getGroupFederationStatusExtensionMeaning(){return(GROUP_FEDERATION_STATUS_EXTENSION_MEANING.asStringValue());}
}
