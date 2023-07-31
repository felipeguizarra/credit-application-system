package me.dio.creditapplication.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplication.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDTO (
    @field:NotEmpty(message = "FirstName Inválido")val firstName: String,
    @field:NotEmpty(message = "LastName Inválido")val lastName: String,
    @field:NotNull(message = "Income não pode estar vazio!")val income: BigDecimal,
    @field:NotEmpty(message = "zipCode Inválido")val zipCode: String,
    @field:NotEmpty(message = "street Inválido")val street: String,
){
    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
