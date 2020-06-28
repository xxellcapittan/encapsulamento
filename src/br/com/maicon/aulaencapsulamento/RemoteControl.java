package br.com.maicon.aulaencapsulamento;

public class RemoteControl implements Controle {
// atributes

    private int volume;
    private boolean ligado;
    private boolean tocando;
// special methods

    public RemoteControl() {
        this.volume = 50;
        this.tocando = true;
        this.ligado = true;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    //abstract methods

    @Override
    public void ligar() {
        this.setLigado(true);
        System.out.println("XingLing TV: ONLINE");
    }

    @Override
    public void desligar() {
        this.setLigado(false);
        System.out.println("Domo arigato");
    }

    @Override
    public void abrirMenu() {
        if (this.getLigado() == true) {
            System.out.println("--- Quick Menu ---");
            System.out.println("Está ligado? " + this.getTocando());
            System.out.println("Está tocando? " + this.getTocando());
            System.out.print("Volume: " + this.getVolume());
            for (int i = 0; i <= this.getVolume(); i += 10) {
                System.out.print(" " + "o");
            }
            System.out.println("");
        } else {
            System.out.println("impossível abrir o menu com a tv desligada!");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu!");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 10);
            System.out.println("Impossível aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() - 10);
        } else {
            System.out.println("Impossível diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0) {
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() == 0) {
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())) {
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()) {
            this.setTocando(false);
        }
    }
}
