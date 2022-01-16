package br.com.jcarvalho.api.surittec.services;

import br.com.jcarvalho.api.surittec.dto.MessageDto;
import br.com.jcarvalho.api.surittec.entity.Cliente;
import br.com.jcarvalho.api.surittec.entity.Operacao;
import br.com.jcarvalho.api.surittec.reporitory.ClienteRepository;
import br.com.jcarvalho.api.surittec.reporitory.OperacaoRepository;
import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.NoSuchElementException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private OperacaoRepository operacaoRepository;

    public ResponseEntity<MessageDto> listarTudo() {
        return ResponseEntity.ok(new MessageDto().messageSucess(repository.findAll()));
    }

    public ResponseEntity<MessageDto<Cliente>> buscarID(Long id) {
        return buscarPorId(id);
    }

    public ResponseEntity<MessageDto<Cliente>> update(Long id, Cliente cliente) {
        ResponseEntity<MessageDto<Cliente>> messageDtoResponseEntity = buscarPorId(id);
        if (!messageDtoResponseEntity.getBody().isErro()) {
            cliente.setId(messageDtoResponseEntity.getBody().getResult().getId());
            repository.save(cliente);
            operacaoRepository.save(new Operacao(null, "ADMIN", Calendar.getInstance().getTime(), "UPDATE", "cliente"));
        }
        return messageDtoResponseEntity;
    }

    public ResponseEntity<MessageDto<Cliente>> delete(Long id) {
        ResponseEntity<MessageDto<Cliente>> messageDtoResponseEntity = buscarPorId(id);
        if (!messageDtoResponseEntity.getBody().isErro()) {
            repository.delete(messageDtoResponseEntity.getBody().getResult());
            operacaoRepository.save(new Operacao(null, "ADMIN", Calendar.getInstance().getTime(), "DELETE", "cliente"));
        }
        return messageDtoResponseEntity;
    }

    public ResponseEntity<MessageDto> save(Cliente cliente) {
        cliente.setData(Calendar.getInstance().getTime());
        Cliente save = repository.save(cliente);
        if (save != null) {
            operacaoRepository.save(new Operacao(null, "ADMIN", Calendar.getInstance().getTime(), "INSERT", "cliente"));
            return ResponseEntity.ok(new MessageDto<Cliente>().messageSucess(save));
        } else {
            return ResponseEntity.badRequest().body(new MessageDto<Cliente>().messageErrorSave(cliente));
        }
    }

    private ResponseEntity<MessageDto<Cliente>> buscarPorId(Long id) {
        try {
            return ResponseEntity.ok(new MessageDto<Cliente>().messageSucess(repository.findById(id).get()));
        } catch (PersistentObjectException | NoSuchElementException e) {
            return ResponseEntity.ok(new MessageDto<>().messageErrorSave(id, "Não foi possível encontrar o Cliente com o ID: " + id));
        }
    }
}
