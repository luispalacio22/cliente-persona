package com.banco.clientepersona.service;

import com.banco.clientepersona.model.Cliente;
import com.banco.clientepersona.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    public void setUp() {
        clienteService = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    public void testCreateCliente() {
        Cliente cliente = new Cliente(1L, "Cliente 1", true);

        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        Cliente nuevoCliente = clienteService.createCliente(cliente);
        assert nuevoCliente != null;
    }

    @Test
    public void testUpdateCliente() {
        Cliente cliente = new Cliente(1L, "Cliente 1", true);

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        Cliente clienteActualizado = clienteService.updateCliente(1L, cliente);
        assert clienteActualizado != null;
    }

    @Test
    public void testDeleteCliente() {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(new Cliente()));
        clienteService.deleteCliente(1L);
    }

    @Test
    public void testGetAllClientes() {
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1L, "Cliente 1", true),
                new Cliente(2L, "Cliente 2", true)
        );

        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.getAllClientes();
        assert !result.isEmpty();
    }

    @Test
    public void testGetClienteById() {
        Cliente cliente = new Cliente(1L, "Cliente 1", true);

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        Cliente result = clienteService.getClienteById(1L);
        assert result != null;
    }
}
