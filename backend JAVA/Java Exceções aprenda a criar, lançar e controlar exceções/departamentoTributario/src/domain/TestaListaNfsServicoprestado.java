package domain;

import java.util.List;

public class TestaListaNfsServicoprestado {
    public static void main(String[] args) {

        Notas nfServico = new Notas("Setembro", "Varilex Transportes Aereos");

        nfServico.adiciona(new NotasServico(101, "Set", 1000.0,
                "Varilex", 5));
        nfServico.adiciona(new NotasServico(102, "Set", 300.0,
                "Varilex", 5));
        nfServico.adiciona(new NotasServico(103, "Set", 1200.0,
                "Varilex", 5));
        nfServico.adiciona(new NotasServico(104, "Set", 5000.0,
                "Varilex", 5));
        nfServico.adiciona(new NotasServico(105, "Set", 10800.0,
                "Varilex", 5));

        List<NotasServico> notasImutaveis = nfServico.getNotasFiscaisServico();

        System.out.println(notasImutaveis);




    }
}
