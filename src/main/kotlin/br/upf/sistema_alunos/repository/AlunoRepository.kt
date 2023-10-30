package br.upf.sistema_alunos.repository

import br.upf.sistema_alunos.model.Aluno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlunoRepository: JpaRepository<Aluno, Long> {
}