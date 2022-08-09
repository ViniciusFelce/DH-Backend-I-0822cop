package entities;

public class Computador {

    private int id;
    private int ram;
    private int hd;
    private int contador = 0;

    public Computador(int id, int ram, int hd) {
        this.id = id;
        this.ram = ram;
        this.hd = hd;
        contador++;
        System.out.println("Contagem de instâncias: " + contador);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computador { " +
                "id=" + id +
                ", ram=" + ram +
                ", hd=" + hd +
                '}';
    }
}
