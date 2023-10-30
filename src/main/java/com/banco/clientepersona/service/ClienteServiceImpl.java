package com.banco.clientepersona.service;

import com.banco.clientepersona.dto.ClienteDTO;
import com.banco.clientepersona.model.Cliente;
import com.banco.clientepersona.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDTO createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setContrasena(cliente.getContrasena());
        clienteDTO.setEstado(cliente.isEstado());
        return clienteDTO;
    }

    @Override
    public ClienteDTO updateCliente(Long clienteId, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + clienteId));
        clienteExistente.setContrasena(cliente.getContrasena());
        clienteExistente.setEstado(cliente.isEstado());
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setGenero(cliente.getGenero());
        clienteExistente.setEdad(cliente.getEdad());
        clienteExistente.setIdentificacion(cliente.getIdentificacion());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteRepository.save(clienteExistente);
        return ClienteDTO.builder().nombre(clienteExistente.getNombre())
                .direccion(clienteExistente.getDireccion())
                .telefono(clienteExistente.getTelefono())
                .contrasena(clienteExistente.getContrasena())
                .estado(cliente.isEstado()).build();
    }

    @Override
    public void deleteCliente(Long clienteId) {
        Cliente clienteExistente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + clienteId));
        clienteRepository.delete(clienteExistente);
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        List<Cliente> list = clienteRepository.findAll();
        List<ClienteDTO> newList = new ArrayList<>();
        for (Cliente cliente: list){
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(cliente.getNombre());
            clienteDTO.setDireccion(cliente.getDireccion());
            clienteDTO.setTelefono(cliente.getTelefono());
            clienteDTO.setContrasena(cliente.getContrasena());
            clienteDTO.setEstado(cliente.isEstado());
            newList.add(clienteDTO);
        }
        return newList;
    }

    @Override
    public ClienteDTO getClienteById(Long clienteId) {
        Cliente cliente =  clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + clienteId));

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setContrasena(cliente.getContrasena());
        clienteDTO.setEstado(cliente.isEstado());
        return clienteDTO;
    }
}
