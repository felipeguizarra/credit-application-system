package me.dio.creditapplication.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import me.dio.creditapplication.system.entity.Credit
import me.dio.creditapplication.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO (
    @field:NotNull(message = "creditValue não pode estar vazio!")val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    @field:Max(value = 48, message = "O número maximo permitido é 48" )val numberOfInstallments: Int,
    @field:NotNull(message = "customerId não pode estar vazio!")val customerId: Long
){
    fun toEntity(): Credit = Credit(
        creditValue =  this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
