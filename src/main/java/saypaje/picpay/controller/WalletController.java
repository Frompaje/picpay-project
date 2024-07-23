package saypaje.picpay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import saypaje.picpay.controller.dto.CreateWalletDTO;
import saypaje.picpay.entity.Wallet;
import saypaje.picpay.service.WalletService;

@Controller
public class WalletController {

    private final WalletService walletService;

    private WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletDTO body) {
        Wallet wallet = walletService.createWallet(body);

        return ResponseEntity.ok(wallet);
    }


}
