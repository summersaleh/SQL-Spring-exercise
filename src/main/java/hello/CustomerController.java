package hello;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CustomerController {
	
	@Resource
	CustomerRepository repo;

	@RequestMapping("/")
	public String fetchCustomer(Model model) {
		model.addAttribute("customerAsCollection", repo.findAll());
		return "customer";
	}

	@RequestMapping("/single")
	public String fetchSingle(@RequestParam("id") Long id, Model model) {
		model.addAttribute("", repo.findOne(id));
		return "single";
	}

}
