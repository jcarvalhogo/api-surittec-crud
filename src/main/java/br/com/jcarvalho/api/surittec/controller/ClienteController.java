package br.com.jcarvalho.api.surittec.controller;

import br.com.jcarvalho.api.surittec.dto.MessageDto;
import br.com.jcarvalho.api.surittec.entity.Cliente;
import br.com.jcarvalho.api.surittec.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public ResponseEntity<MessageDto> listarTodos() {
        return service.listarTudo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto<Cliente>> buscarId(@PathVariable("id") Long id) {
        return service.buscarID(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MessageDto> save(@RequestBody @Validated Cliente cliente) {
        return service.save(cliente);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody @Validated Cliente cliente) {
        return service.update(id, cliente);
    }

}
