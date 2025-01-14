package it.dedagroup.project_cea.controller;

import it.dedagroup.project_cea.dto.request.*;
import it.dedagroup.project_cea.dto.response.CustomerDtoResponse;
import it.dedagroup.project_cea.facade.CustomerFacade;
import it.dedagroup.project_cea.model.Bill;
import it.dedagroup.project_cea.model.Intervention;
import it.dedagroup.project_cea.model.Scan;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static it.dedagroup.project_cea.util.UtilPath.*;

@RestController
public class CustomerController {
	//TODO validate i request param e i pathvariable
	@Autowired
	CustomerFacade customerFacade;

	@PostMapping(SAVE_PATH)
	public ResponseEntity<Void> addCustomer(@Valid @RequestBody AddCustomerDtoRequest request){
		customerFacade.saveCustomer(request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@PostMapping(MODIFY_PATH)
	public ResponseEntity<Void> modifyCustomer(@Valid @RequestBody EditCustomerDto request){
		customerFacade.modifyCustomer(request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@PostMapping(DELETE_PATH+"{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable long id){
		customerFacade.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@PostMapping(BOOK_INTERVENTIONS_PATH)
	public ResponseEntity<Intervention> bookIntervention(@Valid @RequestBody BookInterventionDto request){
		return ResponseEntity.ok(customerFacade.bookIntervention(request));
	}
	
	@GetMapping(BILL_PAYMENT_PATH)
	public ResponseEntity<Bill> payBill(@Valid @RequestBody PayBillDto request){
		return ResponseEntity.ok(customerFacade.payBill(request));
	}
	
	@GetMapping(AUTO_SCAN_PATH)
	public ResponseEntity<Scan> autoScan(@Valid @RequestBody MeterScanDto request){
		return ResponseEntity.ok(customerFacade.autoScan(request));
	}
	
	@GetMapping(GET_BILLS_PATH)
	public ResponseEntity<List<Bill>> getBills(@RequestParam("id") long id_customer){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.getBills(id_customer));
	}
	@GetMapping(GET_CUSTOMER_BY_ID_PATH+"{id}")
	public ResponseEntity<CustomerDtoResponse> findCustomerById(@PathVariable("id") long id_customer) {
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findCustomerById(id_customer));
	}
	@GetMapping(GET_ALL_CUSTOMER_PATH)
	public ResponseEntity<List<CustomerDtoResponse>> findAllCustomer(){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findAllCustomer());
	}
	@PostMapping("/login")
	public ResponseEntity<CustomerDtoResponse> findCustomerByUsernameAndPassword(@RequestBody @Valid LoginDTORequest request){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findCustomerByUsernameAndPassword(request));
	}
	@GetMapping(GET_CUSTOMER_BY_USERNAME_PATH)
	public ResponseEntity<CustomerDtoResponse> findCustomerByUsername(@RequestParam("username") String username){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findCustomerByUsername(username));
	}
	@GetMapping(GET_CUSTOMER_BY_TAX_CODE_PATH)
	public ResponseEntity<CustomerDtoResponse> findCustomerByTax_Code(@RequestParam("tax_code") String taxCode){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findCustomerByTax_Code(taxCode));
	}
	@GetMapping(FIND_ALL_BY_NAME_AND_SURNAME_PATH)
	public ResponseEntity<List<CustomerDtoResponse>> findAllCustomerByNameAndSurname(@RequestBody @Valid CustomerNameSurnameDtoRequest request){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findAllCustomerByNameAndSurname(request));
	}
	@GetMapping(FIND_CUSTOMER_BY_APARTMENT_ID_PATH+"{id}")
	public ResponseEntity<CustomerDtoResponse> findCustomerByApartments_Id(@PathVariable("id") long id_apartment){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerFacade.findCustomerByApartments_Id(id_apartment));
	}
}
