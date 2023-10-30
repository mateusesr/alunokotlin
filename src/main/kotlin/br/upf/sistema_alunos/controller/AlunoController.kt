package br.upf.sistema_alunos.controller

import br.upf.sistema_alunos.dto.*
import br.upf.sistema_alunos.service.AlunoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/alunos")
class AlunoController(val service: AlunoService) {

    @GetMapping
    fun listar(): List<AlunoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AlunoResponseDTO? {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: AlunoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AlunoResponseDTO> {
        val userResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/alunos/${userResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: AlunoDTO
    ): AlunoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}