package fao.org.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fao.org.DTO.UserDTO;

@RestController
public class UserController {
	
	
	
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
	}
	
	@GetMapping("/user")
	public List<UserDTO> getAll() {
		return usuario;
	}
	@GetMapping("/users/{cpf}")
	public UserDTO getUserFiltroCpf(@PathVariable String cpf) {
		for(UserDTO userDTO : usuario) {
			if(userDTO.getCpf().equals(cpf)) {
				return userDTO;
			}
		}
		return null;
	}

}
