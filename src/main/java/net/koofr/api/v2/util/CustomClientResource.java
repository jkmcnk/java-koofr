package net.koofr.api.v2.util;

import org.restlet.Response;
import org.restlet.data.Reference;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;
import org.restlet.ext.oauth.ProtectedClientResource;

public class CustomClientResource extends ProtectedClientResource {

  public CustomClientResource(Reference reference) {
    super(reference);
  }

  @SuppressWarnings("unchecked")
  public Representation handleInbound(Response response) {
    Representation rep = super.handleInbound(response);

    Series<Header> headers = (Series<Header>) response.getAttributes().
        get(HeaderConstants.ATTRIBUTE_HEADERS);

    try {
      String location = headers.getFirstValue("Location");
      rep.setLocationRef(location);
    } catch (Exception e) {
    }

    return rep;
  }
}
