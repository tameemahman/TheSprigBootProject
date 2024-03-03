package com.angularspringbootecommerce.backend.repository;

import com.angularspringbootecommerce.backend.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Long> {
}
