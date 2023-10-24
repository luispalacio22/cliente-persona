package com.banco.clientepersona.service;

import com.banco.clientepersona.model.Cliente;
import com.banco.clientepersona.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long clienteId, Cliente cliente) {
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
        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void deleteCliente(Long clienteId) {
        Cliente clienteExistente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + clienteId));
        clienteRepository.delete(clienteExistente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + clienteId));
    }
}
