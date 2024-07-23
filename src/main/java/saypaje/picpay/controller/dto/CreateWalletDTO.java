package saypaje.picpay.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import saypaje.picpay.entity.Wallet;
import saypaje.picpay.entity.WalletType;

public record CreateWalletDTO(
        @NotBlank String userName,
        @NotBlank String cpf,
        @NotBlank String cnpj,
        @NotBlank String email,
        @NotNull String password, WalletType.Enum walletType) {

    public Wallet toWallet(){
        return new Wallet(userName,cpf,cnpj,email,password,walletType.get());
    }
}
