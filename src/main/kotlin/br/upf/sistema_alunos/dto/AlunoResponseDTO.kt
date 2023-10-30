package br.upf.sistema_alunos.dto

data class AlunoResponseDTO(
    val id: Long? = null,
    val nome: String,
    val email: String,
    val data_nascimento: String,
    val disciplinas: String,
)