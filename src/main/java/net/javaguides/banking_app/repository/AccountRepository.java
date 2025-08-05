package net.javaguides.banking_app.repository;

import net.javaguides.banking_app.entity.Account;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {



}
