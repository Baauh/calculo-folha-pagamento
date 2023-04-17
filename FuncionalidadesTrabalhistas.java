import java.util.Scanner;

public class FuncionalidadesTrabalhistas {

    private double salarioBruto;
    private int horasTrabalhadasDiarias;
    private int diasTrabalhadosSemanais;
    private int grauInsalubridade;
    private boolean atividadePerigosa;
    private double tarifaTransportePublico;
    private boolean recebeValeTransporte;

    public FuncionalidadesTrabalhistas(double salarioBruto, int horasTrabalhadasDiarias, int diasTrabalhadosSemanais,
            int grauInsalubridade, boolean atividadePerigosa, double tarifaTransportePublico,
            boolean recebeValeTransporte) {
        this.salarioBruto = salarioBruto;
        this.horasTrabalhadasDiarias = horasTrabalhadasDiarias;
        this.diasTrabalhadosSemanais = diasTrabalhadosSemanais;
        this.grauInsalubridade = grauInsalubridade;
        this.atividadePerigosa = atividadePerigosa;
        this.tarifaTransportePublico = tarifaTransportePublico;
        this.recebeValeTransporte = recebeValeTransporte;
    }

    public double calcularSalarioHora() {
        int cargaHorariaSemanal = this.horasTrabalhadasDiarias * this.diasTrabalhadosSemanais;
        int cargaHorariaMensal = cargaHorariaSemanal * 4; // considerando 4 semanas no mês
        double salarioHora = this.salarioBruto / cargaHorariaMensal;
        return salarioHora;
    }

    public double calcularPericulosidade() {
        double adicionalPericulosidade = 0;
        if (this.atividadePerigosa) {
            adicionalPericulosidade = this.salarioBruto * 0.3; // adicional de 30% do salário
        }
        return adicionalPericulosidade;
    }

    public double calcularInsalubridade() {
        double adicionalInsalubridade = 0;
        switch (this.grauInsalubridade) {
            case 10:
                adicionalInsalubridade = 0.1 * this.salarioBruto;
                break;
            case 20:
                adicionalInsalubridade = 0.2 * this.salarioBruto;
                break;
            case 40:
                adicionalInsalubridade = 0.4 * this.salarioBruto;
                break;
        }
        return adicionalInsalubridade;
    }

    public double calcularDescontoValeTransporte() {
        double descontoValeTransporte = 0;
        if (this.recebeValeTransporte) {
            double valorValeTransporte = this.tarifaTransportePublico * this.diasTrabalhadosSemanais * 4; // considerando 4 semanas no mês
            if (valorValeTransporte > 0.06 * this.salarioBruto) {
                descontoValeTransporte = 0.06 * this.salarioBruto;
            } else {
                descontoValeTransporte = valorValeTransporte;
            }
        }
        return descontoValeTransporte;
    }

}