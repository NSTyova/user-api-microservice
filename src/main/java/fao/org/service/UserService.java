package fao.org.service;

import java.util.List;

import fao.org.DTO.UserDTO;

public interface UserService {

	public List<UserDTO> getAll();
	public UserDTO findById(Long id);
	public UserDTO save(UserDTO userDTO);
	public UserDTO delete(long userId);
	public UserDTO findByCpf(String cpf);
	public List<UserDTO> queryByName(String nome);
}
