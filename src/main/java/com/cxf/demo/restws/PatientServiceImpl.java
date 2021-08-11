package com.cxf.demo.restws;

import com.cxf.demo.restws.exceptions.PatientBusinessException;
import com.cxf.demo.restws.model.Patient;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author olysenko
 */
@Service
public class PatientServiceImpl implements PatientService {

   private Map<Long, Patient> patients = new HashMap<>();
   private long currentId = 1L;

   public PatientServiceImpl() {
      init();
   }

   private void init() {
      Patient patient = new Patient();
      patient.setId(currentId);
      patient.setName("Vasya");
      patients.put(patient.getId(), patient);
   }

   @Override
   public List<Patient> getPatients() {
      return new ArrayList<>(patients.values());
   }

   @Override
   public Patient getPatient(Long id) {
      Patient patient = patients.get(id);
      if (patient == null) {
         throw new NotFoundException();
      }
      return patient;
   }

   @Override
   public Response createPatient(Patient patient) {
      patient.setId(++currentId);
      patients.put(patient.getId(), patient);
      return Response.ok(patient).build();
   }

   @Override
   public Response updatePatient(Patient patient) {
      Response response;
      Patient currentPatient = patients.get(patient.getId());
      if (currentPatient != null) {
         patients.put(patient.getId(), patient);
         response = Response.ok().build();
      } else {
         throw new PatientBusinessException();
      }
      return response;
   }

   @Override
   public Response deletePatient(Long id) {
      Patient removed = patients.remove(id);
      return removed != null ? Response.ok().build() : Response.notModified().build();
   }
}
