/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fhirbox.pegacorn.fhir.r4.model.digitaltwin;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import net.fhirbox.pegacorn.fhir.r4.model.common.GroupPC;
import net.fhirbox.pegacorn.fhir.r4.model.common.PractitionerPC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mark A. Hunter (ACT Health)
 */
@ResourceDef(name = "PractitionerDT", profile = "http://hl7.org/fhir/profiles/custom-resource")
public class PractitionerDT extends PractitionerPC
{
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(PractitionerDT.class);
//    private static final GroupExtensionMeanings pegacornGroupExtensionMeanings = new GroupExtensionMeanings();

    @Override
    public PractitionerDT copy()
    {
        PractitionerDT retVal = new PractitionerDT();
        super.copyValues(retVal);
        return (retVal);
    }

    public PractitionerDT()
    {
        super();
        FhirContext ctx = FhirContext.forR4();
        ctx.registerCustomType(GroupPC.class);
    }        
}
