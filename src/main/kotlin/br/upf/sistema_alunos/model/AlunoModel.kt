package br.upf.sistema_alunos.model
import jakarta.persistence.*

@Entity
data class Aluno(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val data_nascimento: String,
    val disciplinas: String,
)