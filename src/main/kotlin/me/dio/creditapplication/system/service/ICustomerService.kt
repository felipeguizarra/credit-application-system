package me.dio.creditapplication.system.service

import me.dio.creditapplication.system.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}