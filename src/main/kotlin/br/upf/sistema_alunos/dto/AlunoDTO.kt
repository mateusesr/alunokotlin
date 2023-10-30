package br.upf.sistema_alunos.dto

data class AlunoDTO(
    val nome: String,
    val email: String,
    val data_nascimento: String,
    val disciplinas: String,
)