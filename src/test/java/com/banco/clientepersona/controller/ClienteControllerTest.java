package com.banco.clientepersona.controller;

import com.banco.clientepersona.dto.ClienteDTO;
import com.banco.clientepersona.model.Cliente;
import com.banco.clientepersona.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ClienteControllerTest {

    private ClienteService clienteService;
    private ClienteController clienteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clienteService =mock(ClienteService.class);
        clienteController = new ClienteController(clienteService);
    }

    @Test
    public void testGetAllClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        clientes.add(new ClienteDTO("Luis", "Cliente 2","q","123",  true));
        clientes.add(new ClienteDTO("Luis", "Cliente 2","q","123",  true));

        Mockito.when(clienteService.getAllClientes()).thenReturn(clientes);

        ResponseEntity<List<ClienteDTO>> response = clienteController.getAllClientes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clientes, response.getBody());
    }
    @Test
    public void testGetClienteById() {
        ClienteDTO cliente = new ClienteDTO("Luis", "Cliente 2","q","123",  true);

        Mockito.when(clienteService.getClienteById(1L)).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.getClienteById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testCreateCliente() {
        Cliente nuevoCliente = new Cliente(null, "Nuevo Cliente",  true);
        ClienteDTO cliente = new ClienteDTO("Luis", "Cliente 2","q","123",  true);

        Mockito.when(clienteService.createCliente(nuevoCliente)).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.createCliente(nuevoCliente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testUpdateCliente() {
        Cliente clienteActualizado = new Cliente(1L, "Cliente Actualizado",  true);
        ClienteDTO cliente = new ClienteDTO("Luis", "Cliente 2","q","123",  true);

        Mockito.when(clienteService.updateCliente(1L, clienteActualizado)).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.updateCliente(1L, clienteActualizado);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testDeleteCliente() {
        ResponseEntity<String> response = clienteController.deleteCliente(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente eliminado con éxito", response.getBody());
    }
}