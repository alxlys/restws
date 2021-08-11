package com.cxf.demo.restws;

import com.cxf.demo.restws.model.Patient;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/patientservice")
public interface PatientService {

   @GET
   @Path("/patients")
   List<Patient> getPatients();

   @GET
   @Path("/patients/{id}")
   Patient getPatient(@PathParam(value = "id") Long id);

   @POST
   @Path("/patients")
   Response createPatient(Patient patient);

   @PUT
   @Path("/patients")
   Response updatePatient(Patient patient);

   @DELETE
   @Path("/patients/{id}")
   Response deletePatient(@PathParam(value = "id") Long id);

}
