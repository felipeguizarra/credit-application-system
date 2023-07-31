package me.dio.creditapplication.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplication.system.entity.Address
import me.dio.creditapplication.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO (
    @field:NotEmpty(message = "FirstName Inválido") val firstName: String,
    @field:NotEmpty(message = "LastName Inválido")val lastName: String,
    @field:NotEmpty(message = "CPF Inválido")
    @field:CPF(message = "CPF Inválido")val cpf: String,
    @field:NotNull(message = "Income não pode estar vazio!") val income: BigDecimal,
    @field:NotEmpty(message = "FirstName Inválido")val email: String,
    @field:NotEmpty(message = "FirstName Inválido")val password: String,
    @field:NotEmpty(message = "FirstName Inválido")val zipCode: String,
    @field:NotEmpty(message = "FirstName Inválido")val street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
