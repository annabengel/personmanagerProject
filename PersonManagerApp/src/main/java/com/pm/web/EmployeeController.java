package com.pm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pm.business.JsonResponse;
import com.pm.business.Employee;
import com.pm.db.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(employeeRepo.findAll());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			if (employeeRepo.existsById(id)) {
				jr = JsonResponse.getInstance(employeeRepo.findById(id));
			} else {
				jr = JsonResponse.getInstance("No employee found for id: " + id);
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody Employee e) {
		JsonResponse jr = null;
		// NOTE: May need to enhance execption handling if more than one excpetion type
		// needs to be caught
		try {
			jr = JsonResponse.getInstance(employeeRepo.save(e));
		} catch (Exception i) {
			jr = JsonResponse.getInstance(i);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody Employee e) {
		JsonResponse jr = null;
		// NOTE: May need to enhance execption handling if more than one excpetion type
		// needs to be caught
		try {
			if (employeeRepo.existsById(e.getId())) {
				jr = JsonResponse.getInstance(employeeRepo.save(e));
			} else {
				jr = JsonResponse
						.getInstance("Employee ID: " + e.getId() + " does not exist and you are attempting to save it");
			}

		} catch (Exception i) {
			jr = JsonResponse.getInstance(i);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Employee e) {
		JsonResponse jr = null;
		// NOTE: May need to enhance execption handling if more than one excpetion type
		// needs to be caught
		try {
			if (employeeRepo.existsById(e.getId())) {
				employeeRepo.delete(e);
				jr = JsonResponse.getInstance("Employee deleted");
			} else {
				jr = JsonResponse.getInstance(
						"Employee ID: " + e.getId() + " does not exist and you are attempting to delete it.");
			}

		} catch (Exception i) {
			jr = JsonResponse.getInstance(i);
		}
		return jr;
	}

}
