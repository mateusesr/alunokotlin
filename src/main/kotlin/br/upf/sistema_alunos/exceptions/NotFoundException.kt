package br.upf.sistema_alunos.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()