package br.upf.sistema_alunos.service
import br.upf.sistema_alunos.converters.AlunoConverter
import br.upf.sistema_alunos.dto.AlunoDTO
import br.upf.sistema_alunos.dto.AlunoResponseDTO
import br.upf.sistema_alunos.exceptions.NotFoundException
import br.upf.sistema_alunos.repository.AlunoRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

private const val ALUNO_NOT_FOUND_MESSAGE = "Aluno não encontrado!"

@Service
class AlunoService(
    private val repository: AlunoRepository,
    private val converter: AlunoConverter
) {
    fun listar(): List<AlunoResponseDTO> {
        return repository.findAll()
            .map(converter::toAlunoResponseDTO)
    }
    fun buscarPorId(id: Long): AlunoResponseDTO? {
        val aluno = repository.findById(id)
        //return null
       return converter.toAlunoResponseDTO(aluno.getOrElse { throw  NotFoundException("Não encontrado") })
    }
    fun cadastrar(dto: AlunoDTO): AlunoResponseDTO {
        return converter.toAlunoResponseDTO(
            repository.save(converter.toAluno(dto)))
    }
    fun atualizar(id: Long, dto: AlunoDTO): AlunoResponseDTO {
        val aluno = repository.findById(id)
            .orElseThrow { NotFoundException("Aluno não encontrado") }
            .copy(
                nome = dto.nome,
                email= dto.email,
                data_nascimento= dto.data_nascimento,
                disciplinas= dto.disciplinas
            )
        return converter.toAlunoResponseDTO(repository.save(aluno))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}