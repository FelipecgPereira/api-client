package com.devsuperiorbootcamp.apiclients.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiorbootcamp.apiclients.dto.ClientDTO;
import com.devsuperiorbootcamp.apiclients.entities.Client;
import com.devsuperiorbootcamp.apiclients.repository.ClientRepository;
import com.devsuperiorbootcamp.apiclients.services.exceptions.DatabaseException;
import com.devsuperiorbootcamp.apiclients.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		Page<ClientDTO> listDto = list.map(x -> new ClientDTO(x));
		
		return listDto;
		
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity =  obj.orElseThrow(() -> new EntityNotFoundException("Entinty not found"));
		
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO inset(ClientDTO dto) {
		Client entity = new Client();
		copyDTOToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(Long id,ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			copyDTOToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found "+ id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Id not found "+ id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrityy violation");
		}
		
	}
	
	private void copyDTOToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());
		entity.setBirthDate(dto.getBirthDate());
	
		
	}

}
