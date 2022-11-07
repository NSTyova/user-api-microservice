package fao.org.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fao.org.DTO.UserDTO;
import fao.org.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
/*	
public static List<UserDTO> usuario= new ArrayList<>();
	
	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("Salvador Tyova");
		userDTO.setNome("Ngundji Salvador Tyova");
		userDTO.setCpf("003580996LA032");
		userDTO.setDataCadastro(new Date());
		
		UserDTO userDTO1 = new UserDTO();
		userDTO1.setEmail("DelfinaTyova");
		userDTO1.setNome("Delfina Tyova");
		userDTO1.setCpf("003580996LA032");
		userDTO1.setDataCadastro(new Date());
		
		
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setEmail("Alira Tyova");
		userDTO2.setNome("Alira Salvador Tyova");
		userDTO2.setCpf("003580996LA032");
		userDTO2.setDataCadastro(new Date());
		
	usuario.add(userDTO);
	usuario.add(userDTO2);
	usuario.add(userDTO1);
	}*/
	
	@GetMapping("/user")
	public List<UserDTO> getAll() {
		List<UserDTO> usuarios = userService.getAll();
		return usuarios;
	}
	
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(
					@RequestParam(name = "nome", required = true)
					String nome){
		return userService.queryByName(nome);
	}
	
	@GetMapping("/user/{id}")
	public UserDTO getById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/users/{cpf}")
	public UserDTO getUserFiltroCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}
	
	@PostMapping("/user")
	UserDTO inserir(@RequestBody UserDTO uDto) {
		return userService.save(uDto);
	}

}
