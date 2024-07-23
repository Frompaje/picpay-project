package saypaje.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saypaje.picpay.entity.Wallet;

import java.util.Optional;


@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCpfOrCnpjOrEmail(String cpf, String cnpj, String email);
}
