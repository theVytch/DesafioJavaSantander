import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        //selecaoCandidatos();
        //imprimirSelecionados();

        String [] candidatos = {"MARIA", "JULIA", "AUGUSTO", "MONICA", "FABRICIO"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativaRealizada = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativaRealizada++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while (continuarTentando && tentativaRealizada<3);

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativaRealizada + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO");
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"MARIA", "JULIA", "AUGUSTO", "MONICA", "FABRICIO"};
        System.out.println("Imprimir a lista de candidatos informando o indice do elento");

        for(int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de numero: " + indice + " é o " + candidatos[indice]);
        }

        System.out.println("Forma abreviada for each");

        for(String candidato : candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARIA", "JULIA", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "MARCOS", "MARIO", "MATHEUS", "CARLOS", "LARISSA", "CAIO", "PEDRO", "RODRIGO", "VICTOR", "GUILHERME"};

        int candidatoSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatoSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            DecimalFormat df = new DecimalFormat("#.##");

            System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + df.format(salarioPretendido));
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidado " + candidato + " foi selecionado para a vaga");
                candidatoSelecionados++;
            }
            candidatoAtual++;

        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidatura(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM OUTRA PROPOSTA");
        }else{
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
