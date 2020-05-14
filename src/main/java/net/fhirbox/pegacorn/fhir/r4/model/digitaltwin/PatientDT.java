/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fhirbox.pegacorn.fhir.r4.model.digitaltwin;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import net.fhirbox.pegacorn.fhir.r4.model.common.GroupPC;
import net.fhirbox.pegacorn.fhir.r4.model.common.PatientPC;
import net.fhirbox.pegacorn.fhir.r4.model.common.PractitionerPC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mark A. Hunter (ACT Health)
 */
@ResourceDef(name = "PatientDT", profile = "http://hl7.org/fhir/profiles/custom-resource")
public class PatientDT extends PatientPC
{
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(PatientDT.class);
//    private static final GroupExtensionMeanings pegacornGroupExtensionMeanings = new GroupExtensionMeanings();

    @Override
    public PatientDT copy()
    {
        PatientDT retVal = new PatientDT();
        super.copyValues(retVal);
        return (retVal);
    }

    public PatientDT()
    {
        super();
        FhirContext ctx = FhirContext.forR4();
        ctx.registerCustomType(GroupPC.class);
    }        
}
