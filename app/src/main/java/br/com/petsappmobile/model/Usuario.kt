package br.com.petsappmobile.model

class Usuario {
    var id: Int = 0
    var nome: String = ""
    var email: String = ""
    var password: String = ""
    var celular: String = ""
    var tipo_cadastro: Int = 0

    override fun toString(): String {
        return "Usuario(id=$id, nome='$nome', email='$email', password='$password', celular='$celular', tipo_cadastro=$tipo_cadastro)"
    }
}
