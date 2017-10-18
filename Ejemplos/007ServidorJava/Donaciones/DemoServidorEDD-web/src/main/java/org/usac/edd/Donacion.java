package org.usac.edd;

/**
 *
 * @author esvux
 */
public class Donacion {

    public Donacion() {
    }
    
    private String donador;
    private Double monto;
    private String voucher;

    public String getDonador() {
        return donador;
    }

    public void setDonador(String donador) {
        this.donador = donador;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
    
}
