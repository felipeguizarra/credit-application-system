package me.dio.creditapplication.system.service.impl

import me.dio.creditapplication.system.entity.Credit
import me.dio.creditapplication.system.repository.CreditRepository
import me.dio.creditapplication.system.service.ICreditService
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCostumerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit =
            (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit Code $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact Admin")
    }
}