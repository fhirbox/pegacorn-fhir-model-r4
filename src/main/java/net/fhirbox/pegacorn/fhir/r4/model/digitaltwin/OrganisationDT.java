/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fhirbox.pegacorn.fhir.r4.model.digitaltwin;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import net.fhirbox.pegacorn.fhir.r4.model.common.GroupPC;
import net.fhirbox.pegacorn.fhir.r4.model.common.OrganisationPC;
import net.fhirbox.pegacorn.fhir.r4.model.common.PractitionerPC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mark A. Hunter (ACT Health)
 */
@ResourceDef(name = "OrganisationDT", profile = "http://hl7.org/fhir/profiles/custom-resource")
public class OrganisationDT extends OrganisationPC
{
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(OrganisationDT.class);
//    private static final GroupExtensionMeanings pegacornGroupExtensionMeanings = new GroupExtensionMeanings();

    @Override
    public OrganisationDT copy()
    {
        OrganisationDT retVal = new OrganisationDT();
        super.copyValues(retVal);
        return (retVal);
    }

    public OrganisationDT()
    {
        super();
        FhirContext ctx = FhirContext.forR4();
        ctx.registerCustomType(GroupPC.class);
    }        
}
