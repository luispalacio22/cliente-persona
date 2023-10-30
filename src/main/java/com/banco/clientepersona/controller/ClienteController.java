package com.banco.clientepersona.controller;

import com.banco.clientepersona.dto.ClienteDTO;
import com.banco.clientepersona.model.Cliente;
import com.banco.clientepersona.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long clienteId) {
        ClienteDTO cliente = clienteService.getClienteById(clienteId);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody Cliente cliente) {
        ClienteDTO nuevo = clienteService.createCliente(cliente);
        return  new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> updateCliente(
            @PathVariable Long clienteId,
            @RequestBody Cliente cliente) {
        ClienteDTO actualizado = clienteService.updateCliente(clienteId, cliente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return new ResponseEntity<>("Cliente eliminado con éxito", HttpStatus.OK);
    }


}
