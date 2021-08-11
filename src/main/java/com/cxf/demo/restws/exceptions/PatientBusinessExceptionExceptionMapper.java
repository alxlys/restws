package com.cxf.demo.restws.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author olysenko
 */
@Provider
public class PatientBusinessExceptionExceptionMapper
      implements ExceptionMapper<PatientBusinessException> {
   @Override
   public Response toResponse(PatientBusinessException e) {
      String sb = "{" + "\"status\":\"error\"," + "\"message\":\"Resource Not Found\"" + "}";
      return Response.serverError().entity(sb).type(MediaType.APPLICATION_JSON_TYPE)
            .build();
   }
}
