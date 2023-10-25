package com.banco.clientepersona.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    @Test
    public void testClienteConstructorAndGetters() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setNombre("John");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("12345");
        cliente.setDireccion("123");
        cliente.setTelefono("5551234");
        cliente.setContrasena("password");
        cliente.setEstado(true);

        assertEquals(1L, cliente.getClienteId());
        assertEquals("John", cliente.getNombre());
        assertEquals("M", cliente.getGenero());
        assertEquals(30, cliente.getEdad());
        assertEquals("12345", cliente.getIdentificacion());
        assertEquals("123", cliente.getDireccion());
        assertEquals("5551234", cliente.getTelefono());
        assertEquals("password", cliente.getContrasena());
        assertEquals(true, cliente.isEstado());
    }

    @Test
    public void testPersonaConstructorAndGetters() {
        Persona persona = new Persona();
        persona.setNombre("Alice");
        persona.setGenero("F");
        persona.setEdad(25);
        persona.setIdentificacion("54321");
        persona.setDireccion("456");
        persona.setTelefono("555-5678");

        assertEquals("Alice", persona.getNombre());
        assertEquals("F", persona.getGenero());
        assertEquals(25, persona.getEdad());
        assertEquals("54321", persona.getIdentificacion());
        assertEquals("456", persona.getDireccion());
        assertEquals("555-5678", persona.getTelefono());
    }
}