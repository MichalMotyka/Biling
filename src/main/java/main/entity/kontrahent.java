package main.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import main.validators.NipVPesel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@NipVPesel
public class kontrahent {
    private int id;
    @Size(min=2, message = "Nie podano nazwy")
    private String nazwa;
    @Pattern(regexp="(^$|.{11,11})", message="Pesel musi składać się z 11 znaków")
    private String pesel;
    @Pattern(regexp="(^$|.{11,11})", message="Nip musi składać się z 10 znaków")
    private String NIP;
    private int saldo;
    @NotNull(message = "Adres nie może być pusty")
    private int idAdres;
    @NotNull(message = "Adres korespodencyjny nie może być pusty")
    private int idAdresKores;
    private String prosument;
    private int nrwPPE;
    @Size(min = 1, message = "Numer domu nie może być pusty")
    private String numerDomu;
    @Size(min = 1, message = "Numer domu nie może być pusty")
    private String numderDomuKores;

    public kontrahent(String nazwa, String pesel, String NIP, int saldo, int idAdres, int idAdresKores, String prosument, int nrwPPE,String numerDomu,String numderDomuKores) {
        this.nazwa = nazwa;
        this.pesel = pesel;
        this.NIP = NIP;
        this.saldo = saldo;
        this.idAdres = idAdres;
        this.idAdresKores = idAdresKores;
        this.prosument = prosument;
        this.nrwPPE = nrwPPE;
        this.numerDomu = numerDomu;
        this.numderDomuKores = numderDomuKores;
    }
}
