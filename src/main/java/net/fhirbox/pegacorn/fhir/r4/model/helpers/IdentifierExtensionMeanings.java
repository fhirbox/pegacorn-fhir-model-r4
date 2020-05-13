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
public class IdentifierExtensionMeanings
{
    private static final UriType IDENTIFIER_ASSOCIATED_FRIENDLY_NAME = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Identifier/identifier_associated_friendly_name");
    private static final UriType IDENTIFIER_ASSOCIATED_AVATAR = new UriType("http://pegacorn.fhirbox.net/pegacorn/fhir/R4/Identifier/identifier_associated_avatar");

    public String getIdentifierAssociatedFriendlyName(){return(IDENTIFIER_ASSOCIATED_FRIENDLY_NAME.asStringValue());}
    public String getIdentifierAssociatedAvatar(){return(IDENTIFIER_ASSOCIATED_AVATAR.asStringValue());}
    
}
