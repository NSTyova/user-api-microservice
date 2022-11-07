package fao.org.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fao.org.DTO.UserDTO;
import fao.org.modelo.User;
import fao.org.repository.UserRepository;
import fao.org.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> getAll() {
		List<User> users=userRepository.findAll();
		return users
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<User> usuario=userRepository.findById(id);
		if(usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		return null;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}

	@Override
	public UserDTO delete(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			userRepository.delete(user.get());
		}
		return null;
	}

	@Override
	public UserDTO findByCpf(String cpf) {
		User user =userRepository.findByCpf(cpf);
		if(user != null) {
			return UserDTO.convert(user);
		}
		return null;
	}

	@Override
	public List<UserDTO> queryByName(String nome) {
		List<User> usuarios = userRepository.queryByNomeLike(nome);
		return usuarios
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
	
	}

}
