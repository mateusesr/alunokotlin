package br.upf.sistema_alunos.converters

import br.upf.sistema_alunos.dto.AlunoDTO
import br.upf.sistema_alunos.dto.AlunoResponseDTO
import br.upf.sistema_alunos.model.Aluno
import org.springframework.stereotype.Component

@Component
class AlunoConverter {
    fun toAluno(dto: AlunoDTO): Aluno {
        return Aluno(
            nome = dto.nome,
            email= dto.email,
            data_nascimento= dto.data_nascimento,
            disciplinas= dto.disciplinas
        )

    }
    fun toAlunoResponseDTO(aluno: Aluno): AlunoResponseDTO {
        return AlunoResponseDTO(
            id = aluno.id,
            nome = aluno.nome,
            email= aluno.email,
            data_nascimento= aluno.data_nascimento,
            disciplinas= aluno.disciplinas
        )
    }


}