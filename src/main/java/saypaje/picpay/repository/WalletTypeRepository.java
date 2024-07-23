package saypaje.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saypaje.picpay.entity.WalletType;


@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
