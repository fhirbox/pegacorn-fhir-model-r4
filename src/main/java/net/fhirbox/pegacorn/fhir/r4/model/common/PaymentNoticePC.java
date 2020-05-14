/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fhirbox.pegacorn.fhir.r4.model.common;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Communication;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.PaymentNotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mark A. Hunter (ACT Health)
 */
@ResourceDef(name = "PaymentNoticePC", profile = "http://hl7.org/fhir/profiles/custom-resource")
public class PaymentNoticePC extends PaymentNotice
{
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(PaymentNoticePC.class);
//    private static final GroupExtensionMeanings pegacornGroupExtensionMeanings = new GroupExtensionMeanings();

    @Override
    public PaymentNoticePC copy()
    {
        PaymentNoticePC retVal = new PaymentNoticePC();
        super.copyValues(retVal);
        return (retVal);
    }

    public PaymentNoticePC()
    {
        super();
        FhirContext ctx = FhirContext.forR4();
        ctx.registerCustomType(GroupPC.class);
    }    
}
