package com.roshka.sifen.core.fields.request.event;

import com.roshka.sifen.core.exceptions.SifenException;
import com.roshka.sifen.internal.response.SifenObjectBase;
import com.roshka.sifen.internal.util.ResponseUtil;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPException;
import org.w3c.dom.Node;

public class TrGeVeCan extends SifenObjectBase {
    private String Id;
    private String mOtEve;

    public void setupSOAPElements(SOAPElement gGroupTiEvt) throws SOAPException {
        SOAPElement rGeVeCan = gGroupTiEvt.addChildElement("rGeVeCan");

        rGeVeCan.addChildElement("Id").setTextContent(this.Id);
        rGeVeCan.addChildElement("mOtEve").setTextContent(this.mOtEve);
    }

    @Override
    public void setValueFromChildNode(Node value) throws SifenException {
        if (value.getLocalName().equals("Id")) {
            this.Id = ResponseUtil.getTextValue(value);
        } else if (value.getLocalName().equals("mOtEve")) {
            this.mOtEve = ResponseUtil.getTextValue(value);
        }
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getmOtEve() {
        return mOtEve;
    }

    public void setmOtEve(String mOtEve) {
        this.mOtEve = mOtEve;
    }
}