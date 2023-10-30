package com.banco.clientepersona.service;

import com.banco.clientepersona.dto.ClienteDTO;
import com.banco.clientepersona.model.Cliente;

import java.util.List;

public interface ClienteService {
    ClienteDTO createCliente(Cliente cliente);
    ClienteDTO updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
    List<ClienteDTO> getAllClientes();
    ClienteDTO getClienteById(Long id);
}
