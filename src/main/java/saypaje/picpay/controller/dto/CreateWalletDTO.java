package saypaje.picpay.controller.dto;

import saypaje.picpay.entity.Wallet;
import saypaje.picpay.entity.WalletType;

public record CreateWalletDTO(
        String userName,
        String cpf,
        String cnpj,
        String email,
        String password, WalletType.Enum walletType) {

    public Wallet toWallet(){
        return new Wallet(userName,cpf,cnpj,email,password,walletType.get());
    }
}
