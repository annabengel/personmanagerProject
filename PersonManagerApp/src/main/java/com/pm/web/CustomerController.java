package com.pm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pm.business.JsonResponse;
import com.pm.business.Customer;
import com.pm.db.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(customerRepo.findAll());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			if (customerRepo.existsById(id)) {
				jr = JsonResponse.getInstance(customerRepo.findById(id));
			} else {
				jr = JsonResponse.getInstance("No customer found for id: " + id);
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody Customer c) {
		JsonResponse jr = null;
		// NOTE: May need to enhance execption handling if more than one excpetion type
		// needs to be caught
		try {
			jr = JsonResponse.getInstance(customerRepo.save(c));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody Customer c) {
		JsonResponse jr = null;
		// NOTE: May need to enhance execption handling if more than one excpetion type
		// needs to be caught
		try {
			if (customerRepo.existsById(c.getId())) {
				jr = JsonResponse.getInstance(customerRepo.save(c));
			} else {
				jr = JsonResponse
						.getInstance("Customer ID: " + c.getId() + " does not exist and you are attempting to save it");
			}

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Customer c) {
		JsonResponse jr = null;
		// NOTE: May need to enhance execption handling if more than one excpetion type
		// needs to be caught
		try {
			if (customerRepo.existsById(c.getId())) {
				customerRepo.delete(c);
				jr = JsonResponse.getInstance("Customer deleted");
			} else {
				jr = JsonResponse.getInstance(
						"Customer ID: " + c.getId() + " does not exist and you are attempting to delete it.");
			}

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

}
