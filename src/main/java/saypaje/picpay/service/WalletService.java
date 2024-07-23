package saypaje.picpay.service;

import org.springframework.stereotype.Service;
import saypaje.picpay.controller.dto.CreateWalletDTO;
import saypaje.picpay.entity.Wallet;
import saypaje.picpay.exceptions.WalletDataAlreadyExistsException;
import saypaje.picpay.repository.WalletRepository;

import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDTO body) {
        Optional<Wallet> isWalletExist = walletRepository.findByCpfOrCnpjOrEmail(body.cpf(), body.cnpj(), body.email());

        if (isWalletExist.isPresent()) {
        throw new WalletDataAlreadyExistsException("Cpf, Cnpj or Email Already exists");
        }

        return walletRepository.save(body.toWallet());

    }
}
