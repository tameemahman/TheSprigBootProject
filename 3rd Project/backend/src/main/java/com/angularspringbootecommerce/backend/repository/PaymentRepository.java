package com.angularspringbootecommerce.backend.repository;

import com.angularspringbootecommerce.backend.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Define any custom query methods if needed
}
