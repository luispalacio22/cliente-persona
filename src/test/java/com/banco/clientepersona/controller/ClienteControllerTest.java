package com.banco.clientepersona.controller;
import com.banco.clientepersona.model.Cliente;
import com.banco.clientepersona.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1L, "Cliente 2",  true));
        clientes.add(new Cliente(2L, "Cliente 2",  true));

        Mockito.when(clienteService.getAllClientes()).thenReturn(clientes);

        ResponseEntity<List<Cliente>> response = clienteController.getAllClientes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clientes, response.getBody());
    }
    @Test
    public void testGetClienteById() {
        Cliente cliente = new Cliente(1L, "Cliente 1", true);

        Mockito.when(clienteService.getClienteById(1L)).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.getClienteById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testCreateCliente() {
        Cliente nuevoCliente = new Cliente(null, "Nuevo Cliente",  true);

        Mockito.when(clienteService.createCliente(nuevoCliente)).thenReturn(nuevoCliente);

        ResponseEntity<Cliente> response = clienteController.createCliente(nuevoCliente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(nuevoCliente, response.getBody());
    }

    @Test
    public void testUpdateCliente() {
        Cliente clienteActualizado = new Cliente(1L, "Cliente Actualizado",  true);

        Mockito.when(clienteService.updateCliente(1L, clienteActualizado)).thenReturn(clienteActualizado);

        ResponseEntity<Cliente> response = clienteController.updateCliente(1L, clienteActualizado);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteActualizado, response.getBody());
    }

    @Test
    public void testDeleteCliente() {
        ResponseEntity<String> response = clienteController.deleteCliente(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente eliminado con éxito", response.getBody());
    }
}