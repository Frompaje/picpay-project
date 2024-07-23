package saypaje.picpay.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "walletType")
@NoArgsConstructor
@Data
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    public WalletType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public enum Enum {

        USER(1L, "user"),
        MECHANT(2L, "merchant");

        Enum(Long id, String description) {
            this.id = id;
            this.description = description;

        }

        private Long id;
        private String description;


        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
